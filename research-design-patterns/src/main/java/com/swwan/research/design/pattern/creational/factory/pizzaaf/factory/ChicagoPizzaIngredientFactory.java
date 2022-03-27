package com.swwan.research.design.pattern.creational.factory.pizzaaf.factory;

import com.swwan.research.design.pattern.creational.factory.pizzaaf.*;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.cheese.MozzarellaCheese;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.clams.FrozenClams;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.dough.ThickCrustDough;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.peppernoi.SlicedPepperoni;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.pizza.CheesePizza;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.pizza.ClamsPizza;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.pizza.PepperoniPizza;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.pizza.VeggiePizza;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.sauce.PlumTomatoSauce;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies.BlackOlives;
import com.swwan.research.design.pattern.creational.factory.pizzaaf.product.veggies.Eggplant;

/**
 * @author swwan
 * @date 2022/3/27 - 22:23
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {
                new BlackOlives(),
                new Eggplant()
        };

        return veggies;
    }

    @Override
    public Pepperoni createPeppernoi() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }

    @Override
    public Pizza create(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        switch (item) {
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Chicago Style Cheese Pizza");
                break;
            case "veggie":
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("Chicago Style Veggie Pizza");
                break;
            case "clam":
                pizza = new ClamsPizza(ingredientFactory);
                pizza.setName("Chicago Style Clam Pizza");
                break;
            case "pepperoni":
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Chicago Style Pepperoni Pizza");
                break;
        }

        return pizza;
    }
}
