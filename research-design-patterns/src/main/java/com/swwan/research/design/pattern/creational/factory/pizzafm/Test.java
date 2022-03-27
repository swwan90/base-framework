package com.swwan.research.design.pattern.creational.factory.pizzafm;

import com.swwan.research.design.pattern.creational.factory.pizzafm.factory.ChicagoPizzaFactory;
import com.swwan.research.design.pattern.creational.factory.pizzafm.factory.NYPizzaFactory;

/**
 * @author swwan
 * @date 2022/3/27 - 22:09
 */
public class Test {

    public static void main(String[] args) {

        PizzaFactory nyPizzaFactory = new NYPizzaFactory();
        PizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();

        PizzaStore store = new PizzaStore(nyPizzaFactory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println(pizza.getName());
        System.out.println("==============");

        pizza = store.orderPizza("clam");
        System.out.println(pizza.getName());
        System.out.println("==============");

        store = new PizzaStore(chicagoPizzaFactory);

        pizza = store.orderPizza("cheese");
        System.out.println(pizza.getName());
        System.out.println("==============");

        pizza = store.orderPizza("clam");
        System.out.println(pizza.getName());
        System.out.println("==============");
    }
}
