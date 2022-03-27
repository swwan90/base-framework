package com.swwan.research.design.pattern.creational.factory.pizzafm;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author swwan
 * @date 2022/3/27 - 21:55
 */
@Data
@ToString
public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;

    protected List<String> toppings;

    {
        toppings = Lists.newArrayList();
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Cutting " + name);
    }
}
