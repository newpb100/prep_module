package com.ams.train;

public class Step06Compare {

    public static void doStep06Compare(){

        // 1. compare of ints
        int a = 1;
        int b = 1;
        if (a == b){
            System.out.println("primitive integers are equal");
        }
        // but
        Integer a1 = 1;
        Integer a2 = 1;
        System.out.println(a1 == a2 ? "Integers with direct assignment are equal" : "Integers with direct assignment are not equal");
            // equal
        // but
        Integer a11 = new Integer(1);
        Integer a12 = new Integer(1);
        System.out.println(a11 == a12 ? "new Integer(1) == new Integer(1) are equal" : "new Integer(1) == new Integer(1) are not equal");
            // not equal
        // but
        Integer a111 = new Integer(1);
        Integer a112 = new Integer(a1);
        System.out.println(a111 == a112 ? "new Integer(1) == new Integer(a1) are equal" : "new Integer(1) == new Integer(a1) are not equal");
            // not equal


        // 2. comparsion of real numbers
        double d1  = 1.0001;
        double d2  = 1.0002;
        double c  = d2 - d1;
        System.out.println("c = " + c);
        //c = 9.999999999998899E-5
        compTwo(d1, d2);

        d1  = 1.00000004;
        d2  = 1.00000005;
        c  = d2 - d1;
        System.out.println("c = " + c);
        //c =9.99999993922529E-9
        compTwo(d1, d2);

        d1  = 1.000000000004;
        d2  = 1.000000000005;
        c  = d2 - d1;
        System.out.println("c = " + c);
        //c =1.000088900582341E-12
        compTwo(d1, d2);

        d1  = 1.0000000000000004;
        d2  = 1.0000000000000005;
        c  = d2 - d1;
        System.out.println("c = " + c);
        //c =1.000088900582341E-12
        compTwo(d1, d2);

        // compare with accur. limit
        d1 = 1.000001;
        d2 = 1.000012;
        if (Math.abs(d2 - d1) < 0.001)
        { System.out.println("its equal!"); }
        else
        { System.out.println("not equal!"); }
    }

    public static void compTwo(double x, double y){
        if (x < y)
            System.out.println("d1 is less d2");
        else if (x == y)
            System.out.println("d1 is equal d2");
    }

}
