package com.swwan.research.design.pattern.creational.factory.pizzafm.product;

import com.swwan.research.design.pattern.creational.factory.pizzafm.Pizza;

/**
 * Created by Gavin on 2017/3/9.
 */
public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }
}
