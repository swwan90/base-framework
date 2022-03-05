package com.swwan.research.common.interceptor;

import cn.hutool.core.util.IdUtil;
import com.swwan.research.common.constant.Constants;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器
 * 1. 为所有请求添加一个traceId
 * <p>
 * MDC（Mapped Diagnostic Context，映射调试上下文）是 log4j 、logback及log4j2
 * 提供的一种方便在多线程条件下记录日志的功能。MDC 可以看成是一个与当前线程绑定的哈希表 ，
 * 可以往其中添加键值对。MDC 中包含的内容可以被同一线程中执行的代码所访问 。
 * 当前线程的子线程会继承其父线程中的 MDC 的内容。当需要记录日志时，只需要从 MDC 中获取所需的信息即可
 * <p>
 * API说明：
 * clear() => 移除所有MDC
 * get (String key) => 获取当前线程MDC中指定key的值
 * getContext() => 获取当前线程MDC的MDC
 * put(String key, Object o) => 往当前线程的MDC中存入指定的键值对
 * remove(String key) => 删除当前线程MDC中指定的键值对
 * <p>
 * 存在的问题：
 * 1. 子线程中打印日志丢失traceId
 * 重写线程池（不考虑直接 new 创建线程的情况，实际应用中应该避免这种用法）
 * 见 ThreadPoolExecutorMdcWrapper 类
 * 2. HTTP调用丢失traceId
 *
 * @author swwan
 * @date 2021/12/19 - 16:43
 * @see "https://mp.weixin.qq.com/s/LpNgF8gvrlSvqyE88El3Ig"
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果有上层调用就用上层的ID
        String traceId = request.getHeader(Constants.TRACE_ID);
        if (traceId == null) {
            traceId = IdUtil.getSnowflake().nextIdStr();
        }

        // 插入traceId
        MDC.put(Constants.TRACE_ID, traceId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 调用结束后删除
        MDC.remove(Constants.TRACE_ID);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
