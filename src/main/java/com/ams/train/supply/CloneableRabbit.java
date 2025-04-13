package com.ams.train.supply;

public class CloneableRabbit implements Cloneable{

    @Override
    public CloneableRabbit clone() {
        try {
            return (CloneableRabbit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void printObjectHash(){
        System.out.println("hashcode of object : " + this.hashCode());
    }
}
