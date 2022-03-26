package com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.Duck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.flystrategy.FlyNoWay;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.quackstrategy.HighQuack;

/**
 * @author swwan
 * @date 2022/3/26 - 22:12
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new HighQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
