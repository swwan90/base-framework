package com.swwan.research.design.pattern.behavioral.observer.demo1.observer;

import com.swwan.research.design.pattern.behavioral.observer.demo1.DisplayElement;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observable;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observer;

/**
 * @author swwan
 * @date 2022/3/27 - 15:54
 */
public class StatisticsDispaly implements Observer, DisplayElement {

    private float maxTemp;
    private float minTemp;
    private float tempSum;
    private int numReadings;
    private Observable weatherData;

    {
        maxTemp = 0.0f;
        minTemp = 0.0f;
        tempSum = 0.0f;
    }

    /**
     * 将自身注册到可观察者，同时持有了可观察者，可以主动获取所有信息
     */
    public StatisticsDispaly(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {

        if (numReadings == 0) {
            maxTemp = temp;
            minTemp = temp;
        }

        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        this.display();
    }
}
