package com.swwan.research.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.swwan.research.enums.annotation.serialize.CustomSerializationEnum;
import com.swwan.research.enums.annotation.serialize.EnumSerialize;
import com.swwan.research.enums.annotation.serialize.EnumSerializeAdapter;
import com.swwan.research.enums.annotation.serialize.concreate.CustomSerializationEnumJsonDeserializer;
import com.swwan.research.enums.annotation.serialize.concreate.CustomSerializationEnumJsonSerializer;
import com.swwan.research.enums.annotation.serialize.concreate.CustomSerializationEnumTypeHandler;
import javafx.util.Pair;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

import java.util.*;

/**
 * @author swwan
 * @date 2022/4/9 - 10:28
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class EnumSerializationConfig {
    private final Map<Class<Enum<?>>, Set<EnumSerialize<?>>> enumSerializes;

    /**
     * 在spring 配置文件中使用{@code custom-serialization-enum.path}即可配置扫描路径，
     * <br>没有配置就使用{@code com.swwan.research}作为默认值
     * <br>如果需要作为基础组件在多个项目中使用，就不是这样配置了，但是原理是一样的
     */
    public EnumSerializationConfig(@Value("${custom-serialization-enum.path:com.swwan.research}") String path) {
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        enumSerializes = getEnumSerializes(provider, path);
        enumSerializes.putAll(getAnnotatedEnums(provider, path));
    }

    @Autowired
    @SuppressWarnings({"unchecked", "rawtypes"})
    void registryConverter(ConverterRegistry converterRegistry) {
        for (Map.Entry<Class<Enum<?>>, Set<EnumSerialize<?>>> classSetEntry : enumSerializes.entrySet()) {
            Class clazz = classSetEntry.getKey();
            CustomSerializationEnum annotation = EnumSerialize.getAnnotation(clazz);
            CustomSerializationEnum.Type type = annotation == null ? CustomSerializationEnum.Type.NAME : annotation.requestParam();
            converterRegistry.addConverter(String.class, clazz, t -> type.getDeserializeObj(clazz, t));
        }
    }

    /**
     * spring会自动加载所有jackson的Bean
     * {@link JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.StandardJackson2ObjectMapperBuilderCustomizer#configureModules}、
     * {@link Jackson2ObjectMapperBuilder#applicationContext},{@link SpringHandlerInstantiator}
     * 而{@link Jackson2ObjectMapperBuilder#modules}会每次调用都覆盖，不适合用来注册jackson的组件（而是适合统一设置），还会覆盖spring自动注册modules<br>
     * 还可以参考{@link JsonComponent}
     */
    @Bean
    @SuppressWarnings({"unchecked", "rawtypes", "JavadocReference"})
    public SimpleModule customSerializationEnumModule() {
        return new SimpleModule() {
            {
                for (Map.Entry<Class<Enum<?>>, Set<EnumSerialize<?>>> classSetEntry : enumSerializes.entrySet()) {
                    Class clazz = classSetEntry.getKey();
                    addDeserializer(clazz, new CustomSerializationEnumJsonDeserializer(new Pair<>(classSetEntry.getKey(), classSetEntry.getValue())));
                    addSerializer(clazz, new CustomSerializationEnumJsonSerializer(new Pair<>(classSetEntry.getKey(), classSetEntry.getValue())));
                }
            }
        };
    }

    @Bean
    @SuppressWarnings({"unchecked", "rawtypes"})
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return t -> {
            for (Map.Entry<Class<Enum<?>>, Set<EnumSerialize<?>>> classSetEntry : enumSerializes.entrySet()) {
                Class clazz = classSetEntry.getKey();
                t.getTypeHandlerRegistry().register(clazz, new CustomSerializationEnumTypeHandler(new Pair<>(classSetEntry.getKey(), classSetEntry.getValue())));
            }
        };
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows(ClassNotFoundException.class)
    private static Map<Class<Enum<?>>, Set<EnumSerialize<?>>> getEnumSerializes(ClassPathScanningCandidateComponentProvider provider, String path) {
        provider.resetFilters(false);
        provider.addIncludeFilter(new AssignableTypeFilter(EnumSerialize.class));
        final Set<BeanDefinition> components = provider.findCandidateComponents(path);
        final Map<Class<Enum<?>>, Set<EnumSerialize<?>>> enumSerializes = new HashMap<>();
        for (final BeanDefinition component : components) {
            final Class<?> cls = Class.forName(component.getBeanClassName());
            if (cls.equals(EnumSerializeAdapter.class)) {
                continue;
            }
            if (cls.isEnum()) {
                for (Object anEnum : EnumSet.allOf((Class) cls)) {
                    enumSerializes.computeIfAbsent((Class<Enum<?>>) cls, t -> new HashSet<>()).add((EnumSerialize<?>) anEnum);
                }
            } else {
                throw new UnsupportedOperationException("Class:" + cls.getCanonicalName() + "is not enum! " + "The class that implements the \"EnumSerialize\" must be an enumeration class.");
            }
        }
        return enumSerializes;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows(ClassNotFoundException.class)
    private static Map<Class<Enum<?>>, Set<EnumSerialize<?>>> getAnnotatedEnums(ClassPathScanningCandidateComponentProvider provider, String path) {
        provider.resetFilters(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(CustomSerializationEnum.class));
        provider.addExcludeFilter(new AssignableTypeFilter(EnumSerialize.class));
        final Set<BeanDefinition> components = provider.findCandidateComponents(path);
        final Map<Class<Enum<?>>, Set<EnumSerialize<?>>> enumSerializes = new HashMap<>();
        for (final BeanDefinition component : components) {
            final Class<?> cls = Class.forName(component.getBeanClassName());
            if (cls.isEnum()) {
                for (Object anEnum : EnumSet.allOf((Class) cls)) {
                    enumSerializes.computeIfAbsent((Class<Enum<?>>) cls, t -> new HashSet<>()).add(new EnumSerializeAdapter((Enum<?>) anEnum));
                }
            } else {
                throw new UnsupportedOperationException("Class:" + cls.getCanonicalName() + "is not enum! " + "The class annotated by \"CustomSerializationEnum\" must be an enumeration class.");
            }
        }
        return enumSerializes;
    }
}
