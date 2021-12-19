package com.swwan.research.common.configure;

import com.swwan.research.common.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置类
 *
 * @author swwan
 * @date 2021/12/19 - 16:01
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，添加拦截路几个和排除拦截路径
        registry.addInterceptor(new LogInterceptor()).addPathPatterns(("/**"));
    }


}
