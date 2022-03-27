package com.swwan.research.design.pattern.structural.decorator.starbuzz.beverage;

import com.swwan.research.design.pattern.structural.decorator.starbuzz.Beverage;

/**
 * @author swwan
 * @date 2022/3/27 - 16:50
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
