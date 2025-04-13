package com.ams.train.supply;

public class SimpleClass {

    public void doSome(){

        int age = 15;

        assert age >= 18 : "AssertionError в вызываемом классе SimpleClass";
    }

    public void printSome(){
        System.out.println("printSome() from SimpleClass");
    }
}
