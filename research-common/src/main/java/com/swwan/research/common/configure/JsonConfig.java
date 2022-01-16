package com.swwan.research.common.configure;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.swwan.research.common.base.IEnum;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author swwan
 * @date 2022/1/16 - 10:17
 */
@Configuration
@SuppressWarnings("all")
public class JsonConfig {

    /**
     * 枚举类型序列化，打印内容：
     *   {
     *     "code": "xx",
     *     "description": "dd"
     *   }
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer enumCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(IEnum.class, new JsonSerializer<IEnum>() {
            @Override
            public void serialize(IEnum tiEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeStringField("code", String.valueOf(tiEnum.getCode()));
                jsonGenerator.writeStringField("description", tiEnum.getDescription());
                jsonGenerator.writeEndObject();
            }
        });

        // TODO 时间打印
    }

}
