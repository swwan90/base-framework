package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.decorator;

import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.Beverage;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.CondimentDecorator;

/**
 * @author swwan
 * @date 2022/3/27 - 16:53
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
