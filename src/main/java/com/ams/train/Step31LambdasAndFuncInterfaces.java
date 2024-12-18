package com.ams.train;

import com.ams.main.service.MyFuncInterface;

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

    }

    public static void simpleWorkWithFuncInterface(MyFuncInterface mif){
        mif.doWork();
    }
}
