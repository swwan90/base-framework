package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.cheese;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Cheese;

/**
 * @author swwan
 * @date 2022/3/27 - 22:54
 */
public class ReggianoCheese implements Cheese {
    @Override
    public String describe() {
        return "Reggiano Cheese";
    }
}