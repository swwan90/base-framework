package com.swwan.research.design.pattern.behavioral.strategy.demo01.quackstrategy;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.QuackBehavior;

/**
 * @author swwan
 * @date 2022/3/26 - 22:05
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
