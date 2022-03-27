package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.clams;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Clams;

/**
 * @author swwan
 * @date 2022/3/27 - 22:49
 */
public class FrozenClams implements Clams {
    @Override
    public String describe() {
        return "Frozen Clams from Chesapeake Bay";
    }
}
