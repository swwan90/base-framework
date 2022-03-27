package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes;

import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.beverage.DarkRoast;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.beverage.Espresso;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.decorator.Mocha;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.decorator.Soy;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.decorator.Whip;

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

        Beverage beverage2 = new DarkRoast();
        beverage2.setSize(Beverage.Size.GRANDE);
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}
