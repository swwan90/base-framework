package com.swwan.research.design.pattern.structural.decorator.starbuzz;

import com.swwan.research.design.pattern.structural.decorator.starbuzz.beverage.DarkRoast;
import com.swwan.research.design.pattern.structural.decorator.starbuzz.beverage.Espresso;
import com.swwan.research.design.pattern.structural.decorator.starbuzz.decorator.Mocha;
import com.swwan.research.design.pattern.structural.decorator.starbuzz.decorator.Whip;

/**
 * @author swwan
 * @date 2022/3/27 - 21:23
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

    }
}
