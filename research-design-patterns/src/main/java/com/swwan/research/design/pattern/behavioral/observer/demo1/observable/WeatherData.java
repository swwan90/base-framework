package com.swwan.research.design.pattern.behavioral.observer.demo1.observable;

import com.google.common.collect.Lists;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observable;
import com.swwan.research.design.pattern.behavioral.observer.demo1.Observer;
import lombok.Getter;

import java.util.List;

/**
 * @author swwan
 * @date 2022/3/27 - 15:44
 */
@Getter
public class WeatherData implements Observable {

    private final List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    {
        observers = Lists.newArrayList();
    }

    public WeatherData() {
    }

    public WeatherData(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        this.measurementsChanged();
    }

    public void measurementsChanged() {
        this.notifyObservers();
    }
}
