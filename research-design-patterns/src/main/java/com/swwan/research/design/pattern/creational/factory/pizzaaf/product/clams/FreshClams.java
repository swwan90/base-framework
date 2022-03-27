package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.clams;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Clams;

/**
 * @author swwan
 * @date 2022/3/27 - 22:48
 */
public class FreshClams implements Clams {
    @Override
    public String describe() {
        return "Fresh Clams from Long Island Sound";
    }
}
