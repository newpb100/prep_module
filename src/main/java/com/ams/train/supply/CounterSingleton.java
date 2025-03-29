package com.ams.train.supply;

public enum CounterSingleton {

    INSTANCE;

    private int value = 0;

    public void setValue(int value){
        this.value = value;
    }

    public void printValue(){
        System.out.println("value = " + value);
    }
}
