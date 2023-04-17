package com.ams.train;

public class Step11DoubleOperations {
    public static void main(String[] args) {

        // 1. Result always celoe
        int a = 5;
        int b = 2;
        double d  = a / b ;
        System.out.println("d  = a / b  = " + d);

        // 2. Int converts to double
        double d1 = 1.5;
        System.out.println("res  = a + d1 ; int to double = 6.5 ; res = " + (a + d1));

        // 3. Double converts to int explicitly and to nearest low
        a = (int) d1;  // always explicit pointer (int)
        System.out.println("a = " + a);
        d1 = 1.99999;
        a = (int) d1;  // round to nearest low
        System.out.println("a = " + a);

        // 4. How to calc with doubles
        int q = 5;
        int w = 2;
        System.out.println("res = " + (q / w));        // 2
        System.out.println("res = " + (q / w * 1.0));  // 2.0
        System.out.println("res = " + (q * 1.0/ w));   // * 1.0 :) = 2.5

        // 5. Rounds
        System.out.println("Math.round(2.7) = " + Math.round(2.7));
        System.out.println("Math.round(2.5) = " + Math.round(2.5));
        System.out.println("Math.round(2.4) = " + Math.round(2.4));

        System.out.println("Math.ceil(2.1) = " + Math.ceil(2.1));
        System.out.println("Math.ceil(2.9) = " + Math.ceil(2.9));
        System.out.println("Math.floor(2.1) = " + Math.floor(2.1));
        System.out.println("Math.floor(2.9) = " + Math.floor(2.9));
        System.out.println("(int)2.7 = " + ((int)2.7));


        // 6. Accurance for float in dec-system

        float f = 0.0f;
        for (int i = 1; i <= 8; i++){
            f = f + 0.11111111111111111111111111111f;
        }
        System.out.println("float f = " + f);   // float f = 0.8888889  only 7 digits after point

        // 7. Range of float
        // 1.4e-45f до 3.4e+38f

        // f = 1.4e-46f;  err : floating point too small
        f = 1.4e-45f;
        System.out.println("minimum float f = " + f);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("Float.MAX_VALUE = " + (2 - Math.pow(2, -23))*Math.pow(2, 127));


    }
}
