package com.ams.train;

import com.ams.train.coffeeshop.*;

/**
 *  Готовим кофе и пончики с помощью фабрик.
 *  Для кофе - классическая фабрика на основе класса и цепочки Enum-Switch-Case-New().
 *  Для пончиков - фабрика на основе енума и анонимных классов.
 *  Также используем рандомный метод вместе с енумом для бонусной акции.
 * */
public class Step36FactoryCoffeeShop {

    public static void main(String[] args) {

        Coffee coffee = null;
        Doughnut doughnut = null;
        boolean bonusday = true;

        CoffeeFactory coffeeFactory = new CoffeeFactory();

        CoffeeShop coffeeShop = new CoffeeShop(coffeeFactory);

        // Заказы
        coffee = coffeeShop.orderCoffee(CoffeeType.LATTE);

        doughnut = coffeeShop.orderDoughnut(DoughnutFactory.ALMOND);
        if (bonusday){
            Doughnut doughnutBonus = coffeeShop.getDoughnutBonus();
        }

        // Вызов метода из наследника, которого нет в Родителе

        // Попытка вызвать кастомный метод drink(), который есть только в Americano-классе
        // Несмотря на то, что происходит явное приведение к Americano-классу - не помогает, drink() будет закрыт т.к. coffee1 присвоено в переменную Coffee
        // Coffee coffee1 = (Americano)coffeeShop.orderCoffee(CoffeeType.AMERICANO);
        // coffee1.drink();
        // err: Cannot resolve method drink()

        // Таким образом, как понимаю, coffee1 будет явно задана Americano-классом, считай объявлена как "Americano coffee1 = .." и метод будет открыт
        // var coffee1 = (Americano)coffeeShop.orderCoffee(CoffeeType.AMERICANO);
        // coffee1.drink();

        // Аналогично, для Doughnut, если в исходном интерфейсе нет метода eat()
        // достучаться до него через doughnut.eat() не получится
        // причем в этом случае, не получается достучаться уже никак
        // пытаюсь созданный объект НЕ присваивать переменной и все равно система НЕ видит метод
        //      coffeeShop.orderDoughnut(DoughnutFactory.ALMOND)).eat();
        // err: Cannot resolve method eat()
        // для решения вопроса, придется вместо анонимных классов использовать стандартные именованные классы
        // тогда можно будет применить подходы, описанные выше для кофе


        System.out.println();
        System.out.println(coffee);
        // Если toString() не переписана: com.ams.train.coffeeshop.Americano@5680a178
    }
}
