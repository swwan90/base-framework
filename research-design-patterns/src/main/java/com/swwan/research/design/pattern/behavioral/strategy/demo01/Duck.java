package com.swwan.research.design.pattern.behavioral.strategy.demo01;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author swwan
 * @date 2022/3/26 - 21:58
 */
@NoArgsConstructor
@Setter
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public abstract void display();

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

}
