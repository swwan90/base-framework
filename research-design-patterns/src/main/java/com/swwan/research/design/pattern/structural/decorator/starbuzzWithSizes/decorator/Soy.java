package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.decorator;

import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.Beverage;
import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.CondimentDecorator;

/**
 * @author swwan
 * @date 2022/3/27 - 16:53
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        double cost = beverage.cost();

        if (beverage.getSize() == Size.TALL) {
            cost += .10;
        } else if (beverage.getSize() == Size.GRANDE) {
            cost += .15;
        } else if (beverage.getSize() == Size.VENTI) {
            cost += 0.20;
        }

        return cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
