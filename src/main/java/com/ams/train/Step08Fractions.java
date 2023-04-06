package com.ams.train;

import java.util.HashSet;
import java.util.Objects;

import static java.util.Objects.hash;

public class Step08Fractions {

    int numerator = 0;
    int denominator = 1;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step08Fractions that = (Step08Fractions) o;
        return numerator * that.denominator == denominator * that.numerator;
    }

    @Override
    public int hashCode() {
        // var aaa = Objects.hash(numerator, denominator);
        var aaa =  numerator/denominator + denominator/numerator;;
        return aaa;
    }

    public Step08Fractions(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static void main (String[] args){
        // 1. Comparing with equals
        Step08Fractions fr1 = new Step08Fractions(2,3);
        Step08Fractions fr2 = new Step08Fractions(4,6);

        System.out.println(fr1.equals(fr2) ? "fr1 == fr2 - it is equal" : "fr1 == fr2 - its NOT equal");

        Step08Fractions fr3 = new Step08Fractions(4,16);

        System.out.println(fr1.equals(fr3) ? "fr1 == fr3 - it is equal" : "fr1 == fr3 - its NOT equal");

        // 2. Comparing with hashCode (automat generated)
        HashSet<Step08Fractions> sett = new HashSet<Step08Fractions>();
        sett.add(new Step08Fractions(2,3));

        // if Objects.hash(numerator, denominator) there will be hash value that NOT EQUAL hash of (2,3) and equals() not will be performed
        // if (numerator/denominator + denominator/numerator) there will be return value that EQUAL (2,3) and equals() will be performed
        System.out.println(sett.contains(new Step08Fractions(4,6)) ? "sett : fraction like this already inside" : "sett : fraction like this NOT inside");

        System.out.println(sett.contains(new Step08Fractions(13,16)) ? "sett : fraction like this already inside" : "sett : fraction like this NOT inside");


    }
}
