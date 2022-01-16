package com.swwan.research.valid;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.swwan.research.common.base.IEnum;
import com.swwan.research.common.entity.enums.DataStatusEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 启动类
 * <p>
 * scanBasePackages：指定包扫描的路径；否则多模块时可能导致jar包中的包无法导入
 *
 * @author swwan
 * @date 2021/12/18 - 14:59
 */

@SpringBootApplication(scanBasePackages = "com.swwan.research")
public class ResearchValidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResearchValidApplication.class, args);
    }
}
