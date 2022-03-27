package com.swwan.research.design.pattern.structural.decorator.starbuzz.beverage;

import com.swwan.research.design.pattern.structural.decorator.starbuzz.Beverage;

/**
 * @author swwan
 * @date 2022/3/27 - 16:50
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
