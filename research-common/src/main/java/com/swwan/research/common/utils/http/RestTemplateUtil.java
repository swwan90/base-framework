package com.swwan.research.common.utils.http;

import cn.hutool.json.JSONUtil;
import com.swwan.research.common.interceptor.traceid.RestTemplateTraceIdInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * RestTemplate工具类
 *
 * @author swwan
 * @date 2021/12/19 - 22:17
 */
public class RestTemplateUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    private void init() {
        // 为RestTemplate添加拦截器
        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateTraceIdInterceptor()));
    }

    /**
     * GET请求
     *
     * @param url 请求地址
     * @return 响应结果JSON字符串
     */
    public static String doGet(String url) {
        return JSONUtil.toJsonStr(restTemplate.getForObject(url, String.class));
    }
}
