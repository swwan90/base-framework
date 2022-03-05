package com.swwan.research.demo.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author swwan
 * @date 2022/3/6 - 0:26
 */
@Slf4j
@Service
public class RetryService {

    /**
     * @Retryable注解的方法不能有返回值，不然@Recover注解的方法无效
     * @Retryable注解: - value: 抛出指定异常才会重试
     * - include：和value一样，默认为空，当exclude也为空时，默认所以异常
     * - exclude：指定不处理的异常
     * - maxAttempts：最大重试次数，默认3次
     * - backoff：重试等待策略，默认使用@Backoff，
     * @Backoff的value默认为1000L； multiplier（指定延迟倍数）
     */
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 2))
    public void devide(double a, double b) {
        log.info("开始进行除法运算");
        if (b == 0) {
            throw new RuntimeException();
        }
        log.info("{} / {} = {}", a, b, a / b);
    }

    /**
     * @Recover注解： 当重试达到指定次数时候该注解的方法将被回调发生的异常类型需要和@Recover注解的参数一致
     */
    @Recover
    public void recover() {
        log.error("被除数不能为0");
    }
}
