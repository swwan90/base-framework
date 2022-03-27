package com.swwan.research.design.pattern.creational.factory.pizzas.product;

import com.swwan.research.design.pattern.creational.factory.pizzas.Pizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:05
 */
public class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}
