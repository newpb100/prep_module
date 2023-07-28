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


        //CHAR
        char symb1 = 1078;      //по индексу символа в таблице UTF-8
        char symb2 = 'ж';       //по значению
        char symb3 = '\u0436';  //через шестнадцатеричную форму Unicode (это всё ещё «ж»), для 1078 в 16-ричной системе это 0436
        // 1 line
        char symb4 = 1079, symb5 = 'з';
        char symb6 = (char) 1079;

        System.out.println("symb1       = " + symb1);  // ж
        System.out.println("symb2       = " + symb2);  // ж
        System.out.println("symb3       = " + symb3);  // ж
        System.out.println("symb4       = " + symb4);  // з
        System.out.println("++symb3     = " + (++symb3)); // так как char - это и целочисленный тип в том числе, то можно так писать  // з

        System.out.println("(char) 1079 = " + symb6);  // з


        // % операция
        System.out.println();
        System.out.println("ostatok = " + (1 % 2));

        //before print it, init it
        Sample ts = new Sample("test string",1);
        String str;
        System.out.println("print object = " + ts);      // ok
        //System.out.println("print object = " + str);   // err


        //CASTs
        // расширение типов
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        float f = lmax;
        System.out.println("");
        System.out.println("Long.MAX_VALUE     = " + Long.MAX_VALUE);    //Long.MAX_VALUE     = 9223372036854775807
        System.out.println("float f = lmax ; f = " + lmax);              //float f = lmax ; f = 9223372036854775807
        f = lmin;
        System.out.println("Long.MIN_VALUE     = " + Long.MIN_VALUE);    //Long.MIN_VALUE     = -9223372036854775808
        System.out.println("float f = lmin ; f = " + lmin);              //float f = lmin ; f = -9223372036854775808

        int intA = Integer.MAX_VALUE;
        System.out.println();
        System.out.println("int intA;                         intA  = " + intA);       //2147483647
        System.out.println("int intA + 1 ;                  intA+1  = " + (intA + 1)); //-2147483648
        long longRes = intA + 1;
        System.out.println("long longRes = intA + 1;       longRes  = " + longRes);    //-2147483648  !!!
        long longRes1 = (long)intA + 1;
        System.out.println("long longRes = (long)intA + 1; longRes1 = " + longRes1);   //2147483648



        // сужение типов
        //#1
        long lmil = 1000000L;               //
        int lMilInt = (int)lmil;            // 00000000 00001111 01000010 01000000 = 1 000 000 dec
        short lMilShort = (short )lMilInt;  //                   01000010 01000000 = 16980 dec
        byte lMilByte = (byte) lMilInt;     //                            01000000 = 64 dec

        System.out.println();
        System.out.println("short lMilShort = (short )lMilInt ; lMilShort = " + lMilShort);
        System.out.println("byte lMilByte = (byte) lMilInt    ; lMilByte  = " + lMilByte);

        //#2
        byte b128 = (byte)128;
        System.out.println();
        System.out.println("byte b128 = (byte)128;                   b128 = " + b128);
                    // результат -128
                    // Обоснование
                    // 128 - 127 (максимальное в диапазоне) = 1; - это остаток, который нужно "проматывать" с другого конца
                    // идем с другого конца
                    // -128 + 1 - 1 = -128  , -1 делаем, потому что за 127 сразу идет -128, которое надо учитывать

        //#3
        long l123 = 1298390390L;               //01001101 01100011 11011101 01110110 = 1298390390 dec
        short sh123 = (short) l123;            //                  11011101 01110110 = 56694 dec ; 56694 - 32767 = 23927; -32768 + 23927 -1 = -8842
                                               //                                                  -1 потому что

        System.out.println("short sh123 = (short) 1298390390L;      sh123 = " + sh123);



        //char и short
        // несмотря на то, что они оба по 2 байта, преобразование обязательно, так как char-беззнаковый
        short shr = 75;
        char sym = (char) shr;
        System.out.println();
        System.out.println("char sym = (char) shr;   sym = " + sym);

        char sym2 = (char)-1;
        System.out.println("char sym2 = (char)-1; sym2           = " + sym2);
        System.out.println("char sym2 = (char)-1; (short)sym2    = " + (short)sym2);
        System.out.println("((short)65535)                       = " + ((short)65535)); //-1        диапазон:-32768    32767
        System.out.println("((short)32768)                       = " + ((short)32768)); //-32768    диапазон:-32768    32767
        System.out.println("char sym2 = (char)-1; (int)sym2      = " + (int)sym2);      //65535     диапазон:0         65535

        // Неявное преобразование к INT
        byte a = 120;
        byte b = 120;
        // byte c = a + b;              // err! result is INT
        int c = a + b;
        byte c1 = (byte)(a + b);        // операция возможна только с явным кастом

        //byte c2 = a + 1;              // err! result is INT, потому что 1 - это беззнаковый литерал типа INT
        byte c2 = (byte)(a + 1);
        //byte c2 = (byte)a + 1;        // Внимание! каст более приоритетный чем арифметическая операция

        byte c3 = 1 + 1;                // загадка! как так?  !!!!!!!!!!!!!!!
        System.out.println();
        System.out.println("byte c3 = 1 + 1; c3 = " + c3);

        short d = 100;
        // short e = d + a;             // err! result is INT
        int e = d + a;
        short e1 = (short)(d + a);      // операция возможна только с явным кастом


        //int to str
        //String str15 = 15; //err
        String str15 = "" + 15;

        //str to int
        int a1 = Integer.parseInt(str15);
        System.out.println();
        System.out.println("print a1 = " + a1);

        // operations from left to right
        int a2 = 5;
        String str5 = a2 + a2 + "" + a2;
        System.out.println("print str5 = " + str5);   // 105 !

        // operations from right to left for =
        a2 = 5;
        int a3 = 6;
        int a4 = 7;
        int a5 = a2 = a3 = a4;
        System.out.println("a5 = " + a5 + " a4 = " + a4 +" a3 = " + a3 +" a2 = " + a2);   // 7 7 7 7

        // increment/decrement , postfix and prefix
        int a6 = 10;
        int y = a6++;
        System.out.println("postfix y = " + y + " ; a6  = " + a6);  // 10 11
        y = ++a6;
        System.out.println("prefix y = " + y + " ; a6  = " + a6);   // 12 12

        //combine
        y += a6;
        System.out.println("combine add y = " + y);      // 12 + 12 = 24
        y /= a6;
        System.out.println("combine division y = " + y); // 24 / 12 = 2

        //logic , has lower priority as compare ops
        System.out.println(" && : " + ( 100 > 2 && 100 < 100 )); // false
        System.out.println(" || : " + ( 100 > 2 || 100 < 100 )); // true

    }

    public static void doNanAndInfinity() {
        //System.out.println(100/0);                // exception! by zero
        System.out.println(100.0/0.0);              //Infinity
        System.out.println(100f/0f);                //Infinity
        System.out.println(100d/0d);                //Infinity
        System.out.println((100d/0d + 1));          //Infinity
        System.out.println((100d/0d * 10));         //Infinity
        System.out.println(-100.0/0.0);             //-Infinity

        System.out.println(0.0/0.0);                //NaN
        System.out.println((0.0/0.0 + 10));         //NaN
        System.out.println((100d/0d + 0.0/0.0));    //Infinity + NaN = NaN
        double a  = 1.0/0.0;
        System.out.println("Infinity / Infinity = " + a/a);   // Infinity / Infinity = NaN

    }
}
