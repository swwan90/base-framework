package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.pizza;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Pizza;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.PizzaIngredientFactory;

/**
 * @author swwan
 * @date 2022/3/27 - 23:12
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory factory;

    public CheesePizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
    }
}
