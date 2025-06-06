package com.ams.train.supply;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;


public class AnimalFeederGeneric<T> {
    private final Class<? extends T> clazz;

    public AnimalFeederGeneric(Class<? extends T> clazz){
        this.clazz = clazz;
    }

    public List<T> feed(List<Animal> animals){
        List<T> arr = new ArrayList<T>();

        animals.forEach(animal -> {

//            if (animal instanceof clazz){        // попытка параметризовать (animal instanceof Cat), err: unknown class clazz
//
//            }

            if (clazz.isInstance(animal)){
                // работают оба варианта кастования
                //T obj = clazz.cast(animal);                  // valid
                T obj = (T) animal;                            // Unchecked cast: 'com.ams.train.supply.Animal' to 'T'
                arr.add(obj);
            }
        });

        return arr;
    }

}
