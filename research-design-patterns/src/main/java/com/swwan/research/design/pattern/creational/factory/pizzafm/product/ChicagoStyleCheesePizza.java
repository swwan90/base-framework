package com.swwan.research.design.pattern.creational.factory.pizzafm.product;

import com.swwan.research.design.pattern.creational.factory.pizzafm.Pizza;

/**
 * Created by Gavin on 2017/3/9.
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
