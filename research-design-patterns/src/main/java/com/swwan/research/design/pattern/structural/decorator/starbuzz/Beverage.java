package com.swwan.research.design.pattern.structural.decorator.starbuzz;

/**
 * @author swwan
 * @date 2022/3/27 - 16:45
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
