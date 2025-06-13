package com.ams.train.supply;

public class Child2 extends Parent2 {

    String name;

    public Child2() {
        System.out.println("Child2 constructor");
    }

    public Child2(int age, String name) {
        System.out.println("Child2 constructor");

        this.name = name;
        this.age = age;
    }

}
