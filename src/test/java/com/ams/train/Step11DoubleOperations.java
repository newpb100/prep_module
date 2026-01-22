package com.ams.train;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        System.out.println();
        System.out.println("Math.round(2.7) = " + Math.round(2.7));
        // 3
        System.out.println();
        System.out.println("Math.round(2.5) = " + Math.round(2.5));
        // 3 , т.е. можно сказать, что классический round() работает как RoundingMode.HALF_UP
        // причем именно HALF_UP, а не HALF_EVEN, потому что
        // HALF_EVEN, например, округлит "2.5" к 2, а "3.5" к 4
        System.out.println("round 2.5f with = RoundingMode.HALF_UP   = " + new BigDecimal("2.5").setScale(0, RoundingMode.HALF_UP));
        System.out.println("round 2.4f with = RoundingMode.HALF_UP   = " + new BigDecimal("2.4").setScale(0, RoundingMode.HALF_UP));
        System.out.println("round 2.5f with = RoundingMode.HALF_EVEN = " + new BigDecimal("2.5").setScale(0, RoundingMode.HALF_EVEN));
        System.out.println("round 3.5f with = RoundingMode.HALF_EVEN = " + new BigDecimal("3.5").setScale(0, RoundingMode.HALF_EVEN));

        System.out.println();
        System.out.println("Math.round(2.4) = " + Math.round(2.4));
        // 2
        System.out.println("Math.ceil(2.1) = " + Math.ceil(2.1));
        // 3
        System.out.println("Math.ceil(2.9) = " + Math.ceil(2.9));
        // 3
        System.out.println("Math.floor(2.1) = " + Math.floor(2.1));
        // 2
        System.out.println("Math.floor(2.9) = " + Math.floor(2.9));
        // 2
        System.out.println("(int)2.7 = " + ((int)2.7));
        // 2


    }
}
