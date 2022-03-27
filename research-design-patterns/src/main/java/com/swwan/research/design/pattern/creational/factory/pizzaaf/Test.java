package com.swwan.research.design.pattern.creational.factory.pizzaaf;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.factory.ChicagoPizzaIngredientFactory;

/**
 * @author swwan
 * @date 2022/3/27 - 22:09
 */
public class Test {

    public static void main(String[] args) {

        ChicagoPizzaIngredientFactory chicagoPizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        PizzaStore store = new PizzaStore(chicagoPizzaIngredientFactory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println(pizza.getName());
        pizza.prepare();
        System.out.println("==============");

        pizza = store.orderPizza("veggie");
        System.out.println(pizza.getName());
        pizza.prepare();
        System.out.println("==============");
//
//        store = new PizzaStore(chicagoPizzaFactory);
//
//        pizza = store.orderPizza("cheese");
//        System.out.println(pizza.getName());
//        System.out.println("==============");
//
//        pizza = store.orderPizza("clam");
//        System.out.println(pizza.getName());
//        System.out.println("==============");
    }
}
