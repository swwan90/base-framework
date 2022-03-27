package com.swwan.research.design.pattern.creational.factory.pizzaaf.factory;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.*;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.cheese.ReggianoCheese;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.clams.FreshClams;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.dough.ThinCrustDough;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.peppernoi.SlicedPepperoni;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.sauce.MarinaraSauce;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies.Garlic;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies.Mushroom;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies.Onion;

/**
 * @author swwan
 * @date 2022/3/27 - 22:23
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom()};
        return veggies;
    }

    @Override
    public Pepperoni createPeppernoi() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }

    @Override
    public Pizza create(String type) {
        return null;
    }
}
