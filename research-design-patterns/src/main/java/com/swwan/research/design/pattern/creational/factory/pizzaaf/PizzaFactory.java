package com.swwan.research.design.pattern.creational.factory.pizzaaf;

/**
 * @author swwan
 * @date 2022/3/27 - 22:01
 */
public abstract class PizzaFactory {

    protected abstract Pizza create(String type);
}
