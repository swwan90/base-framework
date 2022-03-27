package com.swwan.research.design.pattern.behavioral.observer.demo1;

/**
 * @author swwan
 * @date 2022/3/27 - 15:41
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
