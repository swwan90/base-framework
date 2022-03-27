package com.swwan.research.design.pattern.creational.factory.pizzas;

/**
 * @author swwan
 * @date 2022/3/27 - 22:09
 */
public class Test {

    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName());
        System.out.println(pizza);

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName());
        System.out.println(pizza);
    }
}
