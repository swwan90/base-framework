package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.sauce;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Sauce;

/**
 * @author swwan
 * @date 2022/3/27 - 22:53
 */
public class PlumTomatoSauce implements Sauce {
    @Override
    public String describe() {
        return "Tomato sauce with plum tomatoes";
    }
}
