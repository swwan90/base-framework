package com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.Duck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.flystrategy.FlyNoWay;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.quackstrategy.MuteQuack;

/**
 * @author swwan
 * @date 2022/3/26 - 22:04
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a duck Decoy");
    }
}
