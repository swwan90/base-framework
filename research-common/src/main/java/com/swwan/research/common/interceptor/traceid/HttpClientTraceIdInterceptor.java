package com.swwan.research.common.interceptor.traceid;

import com.swwan.research.common.constant.Constants;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.slf4j.MDC;

import java.io.IOException;

/**
 * 添加HttpClient拦截器
 *
 * @author swwan
 * @date 2021/12/19 - 22:02
 */
public class HttpClientTraceIdInterceptor implements HttpRequestInterceptor {
    @Override
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        String traceId = MDC.get(Constants.TRACE_ID);
        // 当前线程调用中有traceId，则将该traceId进行透传
        if (traceId != null) {
            httpRequest.addHeader(Constants.TRACE_ID, traceId);
        }
    }
}
