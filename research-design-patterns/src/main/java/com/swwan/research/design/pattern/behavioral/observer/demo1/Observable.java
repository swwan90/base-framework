package com.swwan.research.design.pattern.behavioral.observer.demo1;


/**
 * @author swwan
 * @date 2022/3/27 - 15:40
 */
public interface Observable {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
