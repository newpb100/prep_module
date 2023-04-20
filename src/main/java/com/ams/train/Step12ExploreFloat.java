package com.ams.train;

import java.math.BigDecimal;

public class Step12ExploreFloat {

    public static void main(String[] args) {

        // 1. Accurance for float in dec-system

        float f = 0.0f;
        for (int i = 1; i <= 8; i++){
            f = f + 0.11111111111111111111111111111f;
        }
        System.out.println("float f = " + f);   // float f = 0.8888889  only 7 digits after point
        f = 1234567890.123f;
        System.out.println("1234567890.123f = " + f);  // 1234567890.123f = 1.23456794E9
        f = 9.8388608f;
        System.out.println("9.8388608f = " + f);  // 9.8388605   -- одно и то же представление
        f = 9.8388605f;
        System.out.println("9.8388605f = " + f);  // 9.8388605   -- одно и то же представление
        f = 1.9999999f;
        System.out.println("1.9999999f = " + f);  // 1.9999999
        f = 0.7777777777777777f;
        System.out.println("0.7777777777777777f = " + f);  // 0.7777778
        f = 2.9999999f;
        System.out.println("2.9999999f = " + f);  // 3.0


        // 2. Range of float
        // 1.4e-45f до 3.4e+38f

        // f = 1.4e-46f;  err : floating point too small
        f = 1.4e-45f;
        System.out.println("minimum float f = " + f);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("Float.MAX_VALUE = " + (2 - Math.pow(2, -23))*Math.pow(2, 127));


        /*
        *  Два важных вывода:
        * 1. В числах большой точности (>15 знаков для double, например), значимая часть отбрасывается
        * double first =  1.00000000000000001;
        * double second = 1.00000000000000002;
        * и в first и в second будет сохранено 1.0;
        *
        * 2. В числах большой точности
        * разные числа получат одно и то же представление в в пк, см. пример выше
        * */


        // 3. Way to compare real numbers with BigDecimal
        BigDecimal a = new BigDecimal(0.0);
        BigDecimal b = new BigDecimal(0.1);
        BigDecimal c = new BigDecimal(0.1);
        for (int i = 1; i <= 11 ; i++){
            a = a.add(b);
        }
        c = b.multiply(new BigDecimal(11));

        System.out.println("a = " + a);
        System.out.println("c = " + c);

        if (a.compareTo(c) == 0){
            System.out.println("a and c are equal");
        }

    }
}
