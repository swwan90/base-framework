package com.swwan.research.design.pattern.creational.factory.pizzas.product;

import com.swwan.research.design.pattern.creational.factory.pizzas.Pizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:05
 */
public class ClamPizza extends Pizza {

    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
}
