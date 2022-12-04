package com.swwan.research;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author swwan
 * @date 2022/1/16 - 18:20
 */
@SpringBootApplication
@MapperScan
public class ResearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResearchDemoApplication.class, args);
    }
}
