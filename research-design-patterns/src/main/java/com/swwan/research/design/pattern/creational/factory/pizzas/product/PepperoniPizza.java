package com.swwan.research.design.pattern.creational.factory.pizzas.product;

import com.swwan.research.design.pattern.creational.factory.pizzas.Pizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:05
 */
public class PepperoniPizza extends Pizza {

    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
}
