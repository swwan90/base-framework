package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.dough;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Dough;

/**
 * @author swwan
 * @date 2022/3/27 - 22:55
 */
public class ThickCrustDough implements Dough {
    @Override
    public String describe() {
        return "ThickCrust Dough";
    }
}
