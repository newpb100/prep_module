package com.ams.train.coffeeshop;


import java.util.Random;

public class CoffeeShop {

    CoffeeFactory coffeeFactory;
    Coffee coffee;

    public CoffeeShop(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType coffeeType) {

        coffee = coffeeFactory.createCoffee(coffeeType);
        //coffee = coffeeFactory.createCoffee(null);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourCoffee();

        System.out.println("Ваш кофе готов! Спасибо, что посетили нас!");

        return coffee;
    }

    public Doughnut orderDoughnut(DoughnutFactory doughnutFactory) {
        System.out.println();

        Doughnut doughnut = (DoughnutFactory.valueOf(doughnutFactory.name())).createDoughnut();
        doughnut.setTopping();

        System.out.println("Ваш пончик готов! Спасибо, что посетили нас!");

        return doughnut;
    }

    public Doughnut getDoughnutBonus() {
        System.out.println();
        System.out.println("Случайным образом дарим вам бонусный пончик!");
        Random random = new Random();
        // nextInt() будет генерировать целые числа в диапазоне [0; X), X - не входит в границы диапазона

        Doughnut doughnut = (DoughnutFactory.values()[random.nextInt(DoughnutFactory.values().length)]).createDoughnut();;
        doughnut.setTopping();

        return doughnut;
    }
}
