package com.swwan.research.design.pattern.behavioral.observer.demo1;

import com.swwan.research.design.pattern.behavioral.observer.demo1.observable.WeatherData;
import com.swwan.research.design.pattern.behavioral.observer.demo1.observer.CurrentConditionsDisplay;
import com.swwan.research.design.pattern.behavioral.observer.demo1.observer.ForecastDisplay;
import com.swwan.research.design.pattern.behavioral.observer.demo1.observer.StatisticsDispaly;

/**
 * @author swwan
 * @date 2022/3/27 - 16:05
 */
public class TestObserverDemo1 {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDispaly statisticsDispaly = new StatisticsDispaly(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("=============");
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("=============");
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
