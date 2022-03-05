package com.swwan.research.common.utils.log;

import cn.hutool.core.util.IdUtil;
import com.swwan.research.common.constant.Constants;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 线程MDC包装工具类
 *
 * @author swwan
 * @date 2021/12/19 - 22:24
 */
public class ThreadMdcUtil {

    /**
     * 线程设置traceId
     */
    public static void setTraceIdIfAbsent() {
        if (MDC.get(Constants.TRACE_ID) == null) {
            MDC.put(Constants.TRACE_ID, IdUtil.getSnowflake().nextIdStr());
        }
    }

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }

    /**
     * 设置子线程MDC
     *
     * @param runnable 子线程
     * @param context  主线程MDC的Map
     * @return Runnable 接口
     */
    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setTraceIdIfAbsent();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
