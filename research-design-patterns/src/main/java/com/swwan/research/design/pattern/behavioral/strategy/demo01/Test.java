package com.swwan.research.design.pattern.behavioral.strategy.demo01;

import com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate.DecoyDuck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate.MallardDuck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.concreate.ModelDuck;
import com.swwan.research.design.pattern.behavioral.strategy.demo01.flystrategy.FlyWithWing;

/**
 * @author swwan
 * @date 2022/3/26 - 22:13
 */
public class Test {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        ModelDuck modelDuck = new ModelDuck();
        DecoyDuck decoyDuck = new DecoyDuck();

        mallardDuck.performQuack();
        modelDuck.performQuack();
        decoyDuck.performQuack();

        Duck duck = new DecoyDuck();
        duck.display();
        duck.performQuack();
        duck.performFly();
        duck.setFlyBehavior(new FlyWithWing());
        duck.performFly();
    }
}
