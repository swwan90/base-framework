package com.swwan.research.design.pattern.structural.decorator.starbuzzWithSizes;

/**
 * @author swwan
 * @date 2022/3/27 - 16:45
 */
public abstract class Beverage {

    protected String description;
    Size size;

    {
        description = "Unknown Beverage";
        size = Size.TALL;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size {TALL, GRANDE, VENTI}
}
