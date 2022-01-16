package com.swwan.research.common.configure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.swwan.research.common.base.IEnum;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author swwan
 * @date 2022/1/16 - 10:17
 */
@Configuration
@SuppressWarnings("all")
public class JsonConfig {

    private static final String STANDARD_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String TIME_PATTERN = "HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer myCustomizer() {
        return jacksonObjectMapperBuilder -> {
            // 处理Enum
            SimpleModule enumModule = new SimpleModule();
            // 给Module 添加一个序列化器
            enumModule.addSerializer(IEnum.class, new JsonSerializer<IEnum>() {
                @Override
                public void serialize(IEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                    // 开始写入对象
                    gen.writeStartObject();
                    // 分别指定 k v   code   description
                    gen.writeStringField("code", String.valueOf(value.getCode()));
                    gen.writeStringField("description", value.getDescription());
                    // 显式结束操作
                    gen.writeEndObject();
                }
            });

            // 初始化JavaTimeModule
            JavaTimeModule javaTimeModule = new JavaTimeModule();

            //处理LocalDateTime
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                    .ofPattern(STANDARD_PATTERN);
            javaTimeModule.addSerializer(LocalDateTime.class,
                    new LocalDateTimeSerializer(dateTimeFormatter));
            javaTimeModule.addDeserializer(LocalDateTime.class,
                    new LocalDateTimeDeserializer(dateTimeFormatter));

            //处理LocalDate
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            javaTimeModule.addSerializer(LocalDate.class,
                    new LocalDateSerializer(dateFormatter));
            javaTimeModule.addDeserializer(LocalDate.class,
                    new LocalDateDeserializer(dateFormatter));

            //处理LocalTime
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
            javaTimeModule.addSerializer(LocalTime.class,
                    new LocalTimeSerializer(timeFormatter));
            javaTimeModule.addDeserializer(LocalTime.class,
                    new LocalTimeDeserializer(timeFormatter));

            /**
             * 1. 支持枚举 {"code":"","description":""}
             * 2. java.util.Date yyyy-MM-dd HH:mm:ss
             * 3. 支持JDK8 LocalDateTime、LocalDate、 LocalTime
             * 4. Jdk8Module模块支持如Stream、Optional等类
             * 5. 序列化时包含所有字段
             * 6. 在序列化一个空对象时时不抛出异常
             * 7. 忽略反序列化时在json字符串中存在, 但在java对象中不存在的属性
             */
            jacksonObjectMapperBuilder.simpleDateFormat(STANDARD_PATTERN)
                    .modules(enumModule, javaTimeModule, new Jdk8Module())
                    .serializationInclusion(JsonInclude.Include.ALWAYS)
                    .failOnEmptyBeans(false)
                    .failOnUnknownProperties(false);
        };
    }

}
