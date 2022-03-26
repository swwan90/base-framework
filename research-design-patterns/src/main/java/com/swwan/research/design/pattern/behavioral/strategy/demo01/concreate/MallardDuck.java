package com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.Duck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.flystrategy.FlyWithWing;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.quackstrategy.HighQuack;

/**
 * @author swwan
 * @date 2022/3/26 - 22:10
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new HighQuack();
        flyBehavior = new FlyWithWing();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
