package com.swwan.research.design.pattern.behavioral.observer.demo1.observer;

import com.swwan.research.design.pattern.behavioral.observer.demo1.DisplayElement;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observable;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observer;

/**
 * @author swwan
 * @date 2022/3/27 - 15:54
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable weatherData;

    /**
     * 将自身注册到可观察者，同时持有了可观察者，可以主动获取所有信息
     */
    public ForecastDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        this.display();
    }
}
