package com.swwan.research.design.pattern.creational.factory.pizzaaf.product.peppernoi;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.Pepperoni;

/**
 * @author swwan
 * @date 2022/3/27 - 22:54
 */
public class SlicedPepperoni implements Pepperoni {

    @Override
    public String describe() {
        return "Sliced Pepperoni";
    }
}