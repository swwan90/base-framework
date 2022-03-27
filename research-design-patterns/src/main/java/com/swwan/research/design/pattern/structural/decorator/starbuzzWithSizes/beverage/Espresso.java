package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.beverage;

import com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes.Beverage;

/**
 * @author swwan
 * @date 2022/3/27 - 16:50
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
