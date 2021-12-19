package com.swwan.research.common.utils.http;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.swwan.research.common.interceptor.traceid.HttpClientTraceIdInterceptor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient 工具类
 *
 * @author swwan
 * @date 2021/12/19 - 22:22
 */
public class HttpClientUtil {

    private static final CloseableHttpClient HTTP_CLIENT = HttpClientBuilder.create()
            .addInterceptorFirst(new HttpClientTraceIdInterceptor())
            .build();

    /**
     * GET请求
     *
     * @param url 请求地址
     * @return 响应结果Json字符串
     */
    public static String doGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = HTTP_CLIENT.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = StrUtil.EMPTY;
        try {
            if (response != null) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONUtil.toJsonStr(result);
    }
}
