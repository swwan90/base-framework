package com.swwan.research.design.pattern.behavioral.observer.demo1.observer;

import com.swwan.research.design.pattern.behavioral.observer.demo1.DisplayElement;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observable;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observer;

/**
 * @author swwan
 * @date 2022/3/27 - 15:54
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Observable weatherData;

    /**
     * 将自身注册到可观察者，同时持有了可观察者，可以主动获取所有信息
     */
    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;

        this.display();
    }
}
