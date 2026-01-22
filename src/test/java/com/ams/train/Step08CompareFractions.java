package com.ams.train;

import java.util.HashSet;

public class Step08CompareFractions {

    int numerator = 0;
    int denominator = 1;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step08CompareFractions that = (Step08CompareFractions) o;
        return numerator * that.denominator == denominator * that.numerator;
    }

    @Override
    public int hashCode() {
        // var aaa = Objects.hash(numerator, denominator);
        var aaa =  numerator/denominator + denominator/numerator;;
        return aaa;
    }

    public Step08CompareFractions(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static void main (String[] args){
        // 1. Comparing with equals
        Step08CompareFractions fr1 = new Step08CompareFractions(2,3);
        Step08CompareFractions fr2 = new Step08CompareFractions(4,6);

        System.out.println(fr1.equals(fr2) ? "fr1 == fr2 - it is equal" : "fr1 == fr2 - its NOT equal");

        Step08CompareFractions fr3 = new Step08CompareFractions(4,16);

        System.out.println(fr1.equals(fr3) ? "fr1 == fr3 - it is equal" : "fr1 == fr3 - its NOT equal");

        // 2. Comparing with hashCode (automat generated)
        HashSet<Step08CompareFractions> sett = new HashSet<Step08CompareFractions>();
        sett.add(new Step08CompareFractions(2,3));

        // if Objects.hash(numerator, denominator) there will be hash value that NOT EQUAL hash of (2,3) and equals() not will be performed
        // if (numerator/denominator + denominator/numerator) there will be return value that EQUAL (2,3) and equals() will be performed
        System.out.println(sett.contains(new Step08CompareFractions(4,6)) ? "sett : fraction like this already inside" : "sett : fraction like this NOT inside");

        System.out.println(sett.contains(new Step08CompareFractions(13,16)) ? "sett : fraction like this already inside" : "sett : fraction like this NOT inside");


    }
}
