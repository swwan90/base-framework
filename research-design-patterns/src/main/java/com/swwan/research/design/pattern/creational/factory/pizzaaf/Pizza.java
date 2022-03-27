package com.swwan.research.design.pattern.creational.factory.pizzaaf;

import lombok.Data;
import lombok.ToString;

/**
 * @author swwan
 * @date 2022/3/27 - 21:55
 */
@Data
@ToString
public abstract class Pizza {

    protected String name;

    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;


    public abstract void prepare();

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
