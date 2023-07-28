package com.ams.train;

import java.util.Arrays;
import java.util.Random;

public class Step24Random {

    public static int a = 41;
    public static int c = 11119;
    public static int m = 11113;
    public static int seed = 1;

    public static void main(String[] args) {

        System.out.println((int)0.0006);
        System.out.println((int)(6 * 0.999999999999));

        //   Math.random
        for (int i = 0; i < 10; i++) {
            System.out.print(Math.random() + " ; ");
        }

        // Random
        var rand = new Random();
        byte[] btarr = new byte[10];
        System.out.println();
        System.out.println("Using Random()");
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextInt(10)); // with bound-not inclusive
        System.out.println(rand.nextInt());

        rand.nextBytes(btarr);
        System.out.println(Arrays.toString(btarr));

        System.out.println("nextGaussian 3 values:");
        System.out.println(rand.nextGaussian());
        System.out.println(rand.nextGaussian());
        System.out.println(rand.nextGaussian());


        //  Custom method
        generateRandomSequenceCustom();

    }

    private static void generateRandomSequenceCustom() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            seed = (a * seed + c) % m;
            System.out.print(seed + " ; ");
        }
    }
}
