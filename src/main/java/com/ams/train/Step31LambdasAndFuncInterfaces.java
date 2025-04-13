package com.ams.train;

import com.ams.main.service.MyFuncInterface;
import com.ams.train.supply.SimpleClass;

import java.util.function.Supplier;

public class Step31LambdasAndFuncInterfaces {


    public static void doLambdasAndFuncInterfaces() {

        simpleWorkWithFuncInterface(
                new MyFuncInterface() {
                    @Override
                    public void doWork() {
                        System.out.println("Output from anonymous class..");
                    }
                }
        );

        simpleWorkWithFuncInterface(() -> {
            System.out.println("Output from lambda-expression..");
        });


        // Создание объекта через ФИ Supplier
        System.out.println();
        Supplier<SimpleClass> supl = ()->{
            return new SimpleClass();               // lambda can be replaced with method reference
        };
        (supl.get()).printSome();

        Supplier<SimpleClass> supl2 = SimpleClass::new;
        (supl2.get()).printSome();

    }

    public static void simpleWorkWithFuncInterface(MyFuncInterface mif){
        mif.doWork();
    }
}
