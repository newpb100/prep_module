package com.ams.train;

import com.ams.train.supply.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Step39ClassCastAndGenericTypes {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<Animal>();
        Cat cat = new Cat();
        Dog dog = new Dog();
        animals.add(cat);
        animals.add(dog);

        //System.out.println(cat.getClass());

        List<Cat> retList = new AnimalFeederGeneric<Cat>(Cat.class).feed(animals);
        /// List<Cat> retList = new AnimalFeederGeneric<Cat>(cat.getClass()).feed(animals);   // Err: Required Class<Cat>, Provided: Class <capture of ? extends Cat>
        /// Причем сигнатура getClass()
        /// public final native Class<?> getClass();
        /// как видим тут нет никакого Class<? extends |X|>
        /// получается в Object.java написана одна сигнатура, а компилятор подставляет другую.
        ///
        /// Чтобы метод работал универсально и в таком виде и в виде с передачей Cat.class
        ///
        /// необходимо переписать сигнатуру конструктора (+ поле изменить) с
        ///  public AnimalFeederGeneric(Class<T> clazz)
        ///  public AnimalFeederGeneric(Class<? extends T> clazz)
        /// см. доп. пояснение
        /// a.getClass() и A.class

        System.out.println();
        if (retList.size() == 1){
            System.out.println("Вернулся список с 1-м покормленным котом, проверим котовый метод:");
            retList.get(0).SpecificCatMethod();
        }else {
            System.out.println(retList.size());
        }
    }
}
