package com.swwan.research.design.pattern.creational.factory.pizzafm.factory;

import com.swwan.research.design.pattern.creational.factory.pizzafm.Pizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.PizzaFactory;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.NYStyleCheesePizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.NYStyleClamPizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.NYStylePepperoniPizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.NYStyleVeggiePizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:23
 */
public class NYPizzaFactory extends PizzaFactory {
    @Override
    protected Pizza create(String type) {
        switch (type) {
            case "cheese":
                return new NYStyleCheesePizza();
            case "veggie":
                return new NYStyleVeggiePizza();
            case "clam":
                return new NYStyleClamPizza();
            case "pepperoni":
                return new NYStylePepperoniPizza();
            default:
                return null;
        }
    }
}
