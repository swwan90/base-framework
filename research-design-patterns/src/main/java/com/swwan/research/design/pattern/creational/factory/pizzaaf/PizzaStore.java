package com.swwan.research.design.pattern.creational.factory.pizzaaf;

/**
 * @author swwan
 * @date 2022/3/27 - 22:08
 */
public class PizzaStore {

    PizzaIngredientFactory factory;

    public PizzaStore(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.create(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
