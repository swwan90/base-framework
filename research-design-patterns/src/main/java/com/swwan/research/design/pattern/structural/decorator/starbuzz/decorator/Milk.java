package com.swwan.research.design.pattern.structural.decorator.starbuzz.decorator;

import com.swwan.research.design.pattern.structural.decorator.starbuzz.Beverage;
import com.swwan.research.design.pattern.structural.decorator.starbuzz.CondimentDecorator;

/**
 * @author swwan
 * @date 2022/3/27 - 16:53
 */
public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
