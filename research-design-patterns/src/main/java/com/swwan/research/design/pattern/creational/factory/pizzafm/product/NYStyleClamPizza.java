package com.swwan.research.design.pattern.creational.factory.pizzafm.product;

import com.swwan.research.design.pattern.creational.factory.pizzafm.Pizza;

/**
 * Created by Gavin on 2017/3/9.
 */
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}
