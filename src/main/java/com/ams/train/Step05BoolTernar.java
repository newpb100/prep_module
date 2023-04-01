package com.ams.train;

public class Step05BoolTernar {

    public static void doStep05() {

        boolean a = true;
        boolean b = true;

        if ((!(a && b)) == (!a || !b)) {
            System.out.println(" !(a && b) equal !a || !b ");
        }

        if ((!(a || !b)) == (!a && b)) {
            System.out.println(" !(a || !b)) equal (!a && b) ");
        }

        //ternar operation
        int m = 2;
        int n = 4;
        int x = m < n ? m : n;
        System.out.println("x = " + x);
        // m < n ? System.out.println("m") : System.out.println("n ");  // not compiled
        //but!
        System.out.println(m < n ? "m less then n" : "somth else");

    }

}
