package com.ams.train;

import java.text.MessageFormat;
import java.util.Date;

public class Step01 {

    public static Sample sm;

    public static void doStep01(){
        sm = new Sample("test string", 1);

        String s = sm.getF1();
        sm.setA(100);
        System.out.println("f1 value = "+s);
        System.out.println("a value = "+sm.getA());

        // err here now
        //sm.useOwnerToCreateCfg();

        // test varargs construction
        Object[] arguments = {
                7,
                new Date(),
                "a disturbance in the Force"
        };
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet "
                        + "{0,number}.", arguments);
        //System.out.println(result);
    }

}
