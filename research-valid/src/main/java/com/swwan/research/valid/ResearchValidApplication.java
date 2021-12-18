package com.swwan.research.valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
