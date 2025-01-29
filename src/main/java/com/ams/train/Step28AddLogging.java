package com.ams.train;

import com.ams.train.supply.Sample;

public class Step28AddLogging {

    public static void doStep28AddLogging(){

        System.out.println("-- doStep28AddLogging --");

        // Check loggin
        //

        // before print it, init it
        Sample ts = new Sample("test string",1);
        String str;
        System.out.println("print object = " + ts);      // ok
        //System.out.println("print object = " + str);   // err
    }
}
