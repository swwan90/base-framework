package com.swwan.research.design.pattern.creational.factory.pizzafm.factory;

import com.swwan.research.design.pattern.creational.factory.pizzafm.Pizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.PizzaFactory;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.ChicagoStyleCheesePizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.ChicagoStyleClamPizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.ChicagoStylePepperoniPizza;
import com.swwan.research.design.pattern.creational.factory.pizzafm.product.ChicagoStyleVeggiePizza;

/**
 * @author swwan
 * @date 2022/3/27 - 22:23
 */
public class ChicagoPizzaFactory extends PizzaFactory {
    @Override
    protected Pizza create(String type) {
        switch (type) {
            case "cheese":
                return new ChicagoStyleCheesePizza();
            case "veggie":
                return new ChicagoStyleVeggiePizza();
            case "clam":
                return new ChicagoStyleClamPizza();
            case "pepperoni":
                return new ChicagoStylePepperoniPizza();
            default:
                return null;
        }
    }
}
