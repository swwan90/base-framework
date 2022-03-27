package com.swwan.research.design.pattern.creational.factory.pizzas;

import com.swwan.research.design.pattern.creational.factory.pizzas.product.CheesePizza;
import com.swwan.research.design.pattern.creational.factory.pizzas.product.ClamPizza;
import com.swwan.research.design.pattern.creational.factory.pizzas.product.PepperoniPizza;
import com.swwan.research.design.pattern.creational.factory.pizzas.product.VeggiePizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:01
 */
public class SimplePizzaFactory {

    public Pizza create(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
