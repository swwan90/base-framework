package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.sauce;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Sauce;

/**
 * @author swwan
 * @date 2022/3/27 - 22:50
 */
public class MarinaraSauce implements Sauce {
    @Override
    public String describe() {
        return "Marinara Sauce";
    }
}
