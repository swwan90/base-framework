package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Veggies;

/**
 * @author swwan
 * @date 2022/3/27 - 22:51
 */
public class Mushroom implements Veggies {
    @Override
    public String describe() {
        return "Mushrooms";
    }
}
