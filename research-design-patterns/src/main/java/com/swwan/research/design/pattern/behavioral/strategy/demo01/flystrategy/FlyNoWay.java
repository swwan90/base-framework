package com.swwan.research.design.pattern.behavioral.strategy.demo01.flystrategy;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.FlyBehavior;

/**
 * @author swwan
 * @date 2022/3/26 - 22:05
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
