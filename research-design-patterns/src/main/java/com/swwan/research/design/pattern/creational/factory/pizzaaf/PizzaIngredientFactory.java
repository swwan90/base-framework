package com.swwan.research.design.pattern.creational.factory.pizzaaf;

/**
 * @author swwan
 * @date 2022/3/27 - 22:58
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPeppernoi();

    Clams createClams();

    Pizza create(String type);
}
