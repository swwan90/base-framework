package com.swwan.research.design.pattern.creational.factory.pizzas.product;

import com.swwan.research.design.pattern.creational.factory.pizzas.Pizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:05
 */
public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Sliced red pepper");
        toppings.add("Sliced black olives");
    }
}
