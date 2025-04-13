package com.ams.train;

import com.ams.train.supply.Child;
import com.ams.train.supply.Parent;

public class Step39ClassCast {

    public static void main(String[] args) {


    ///    https://codegym.cc/groups/posts/java-class-cast-method
        // public T[] cast(Object obj),

        Parent prn = new Parent();
        Child chl = new Child();

        Object a = chl;
        System.out.println(a.getClass());
        // class com.ams.train.supply.Child

        // casts object
        Object b = Parent.class.cast(chl);     // redundant call to cast

        Object c = (Parent)chl;     // redundant call to cast

        System.out.println();
        System.out.println(prn.getClass());
        System.out.println(chl.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
        //class com.ams.train.supply.Parent
        //class com.ams.train.supply.Child
        //class com.ams.train.supply.Child
        //class com.ams.train.supply.Child


        /// https://www.geeksforgeeks.org/class-cast-method-in-java-with-examples/
        Class<?> myClass = null;
        try {
            myClass = Class.forName("com.ams.train.supply.Parent");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object a1 = myClass.cast(chl);

        System.out.println();
        System.out.println(a1.getClass());
        // class com.ams.train.supply.Child             Почему Child ???
    }



}
