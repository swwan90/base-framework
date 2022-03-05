package com.swwan.research.demo.retry;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * 重试配置类，开启重试功能
 *
 * @author swwan
 * @date 2022/3/6 - 0:24
 */
@EnableRetry
@Configuration
public class RetryConfiguration {
}
