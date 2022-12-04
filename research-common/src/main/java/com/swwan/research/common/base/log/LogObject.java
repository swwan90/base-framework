package com.swwan.research.common.base.log;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 日志对象
 * 使用JsonProperty注解，指定字段的顺序
 * <p>
 * 使用方法：
 * 1. 在代码里使用try catch finally。
 * - 优点，性能高
 * - 缺点，就是每个业务方法都得处理日志
 * 2. 使用aop加thread local的方式，将请求统一拦截且将返回值和请求参数串起来
 * - 优点，一次实现，处处生效
 * - 缺点，使用反射，性能较差
 */
public class LogObject {

    /**
     * 方法名
     */
    @JsonProperty(index = 1)
    private String eventName;

    /**
     * 调用链id
     */
    @JsonProperty(index = 2)
    private String traceId;

    /**
     * 结果消息
     */
    @JsonProperty(index = 3)
    private String msg;

    /**
     * 接口响应时间
     */
    @JsonProperty(index = 4)
    private long costTime;

    /**
     * C端用户id
     */
    @JsonProperty(index = 6)
    private Integer userId;

    /**
     * 其他业务参数
     */
    @JsonProperty(index = 7)
    private Object others;

    /**
     * 接口请求入参
     */
    @JsonProperty(index = 8)
    private Object request;

    /**
     * 接口返回值
     */
    @JsonProperty(index = 9)
    private Object response;


    public String getEventName() {
        return eventName;
    }

    public LogObject setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Object getRequest() {
        return request;
    }

    public LogObject setRequest(Object request) {
        this.request = request;
        return this;
    }

    public Object getResponse() {
        return response;
    }

    public LogObject setResponse(Object response) {
        this.response = response;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public LogObject setMsg(String msg) {
        this.msg = msg;
        return this;
    }


    public long getCostTime() {
        return costTime;
    }

    public LogObject setCostTime(long costTime) {
        this.costTime = costTime;
        return this;
    }


    public Integer getUserId() {
        return userId;
    }

    public LogObject setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Object getOthers() {
        return others;
    }

    public LogObject setOthers(Object others) {
        this.others = others;
        return this;
    }

    public String getTraceId() {
        return traceId;
    }

    public LogObject setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }
}