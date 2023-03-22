package com.ams.train;

public class Step02Types {

    public static void doStep02Types(){

        /* primitive rules */
        //
        float fl = 1.457f;
        long lg = -9223372036854L;
        Long boxl1 = Long.valueOf(lg);
        Long boxl2 = lg;   // неявно вызывается valueOf
        System.out.println("boxl1 = " + boxl1 + "; boxl2 = " + boxl2);

        Long box3 = 1234567L;
        long lg3 = box3.longValue();
        long lg4 = box3;  // неявно вызывается longValue
        System.out.println("lg3 = " + lg3 + "; lg4 = " + lg4);

        char symb1 = 1078;      //по индексу символа в таблице UTF-8
        char symb2 = 'ж';       //по значению
        char symb3 = '\u0436';  //через шестнадцатеричную форму Unicode (это всё ещё «ж»)
        // 1 line
        char symb4 = 1079, symb5 = 'з';

        System.out.println("symb1 = " + symb1);
        System.out.println("symb2 = " + symb2);
        System.out.println("symb3 = " + symb3);
        System.out.println("symb4 = " + symb4);

        System.out.println("ostatok = " + (1 % 2));

        //before print it, init it
        Sample ts = new Sample("test string",1);
        String str;
        System.out.println("print object = " + ts);      // ok
        //System.out.println("print object = " + str);   // err

        //int to str
        //String str15 = 15; //err
        String str15 = "" + 15;

        //str to int
        int a1 = Integer.parseInt(str15);
        System.out.println("print a1 = " + a1);

        // operations from left to right
        int a2 = 5;
        String str5 = a2 + a2 + "" + a2;
        System.out.println("print str5 = " + str5);   // 105 !
    }
}
