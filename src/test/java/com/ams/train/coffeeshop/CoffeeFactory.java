package com.ams.train.coffeeshop;

public class CoffeeFactory {

    Coffee coffee;

    public Coffee createCoffee(CoffeeType coffeeType){

        if (coffeeType == null){
            throw new IllegalArgumentException("coffeeType cannot be null");
        }

        switch(coffeeType) {
            case AMERICANO :
                //System.out.println("case AMERICANO");
                coffee = new Americano();
                break;
            case CAPPUCCINO:
                //System.out.println("case AMERICANO");
                coffee = new Cappuccino();
                break;
            case LATTE:
                //System.out.println("case AMERICANO");
                coffee = new Latte();
                break;
            case ESPRESSO:
                //System.out.println("case AMERICANO");
                coffee = new Espresso();
                break;
            default:
                throw new IllegalArgumentException("Illegal coffeeType");
        }

        return coffee;

    }
}
