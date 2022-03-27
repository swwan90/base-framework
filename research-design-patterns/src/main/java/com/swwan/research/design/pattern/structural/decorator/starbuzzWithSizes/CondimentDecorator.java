package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes;

/**
 * @author swwan
 * @date 2022/3/27 - 16:48
 */
public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;

    @Override
    public abstract String getDescription();

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
