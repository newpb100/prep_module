package com.ams.train;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Step14Arrays {

    public static void main(String[] args) {

        // 1. Simple

        int[] a = new int[10];
        int[] b;

        b = a;

        a[9] = 122;

        System.out.println("b[9] = " + b[9]);

        System.out.println();


        // 2. Default values

        boolean[] bb = new boolean[3];
        for (int i = 0; i < bb.length; i++) {
            System.out.println(bb[i]);
        }
        int[] ii = new int[3];
        for (int i = 0; i < ii.length; i++) {
            System.out.println(ii[i]);
        }
        double[] dd = new double[3];
        for (int i = 0; i < dd.length; i++) {
            System.out.println(dd[i]);
        }
        String[] ss = new String[3];
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }

        System.out.println();

        // 3. Multilayer array

        int[][] array = {
                {1,2,3,3},
                {4,5,6,6},
                {7,8,9,10}
        };
        System.out.println("multi layer array length = " + array.length);

        int[][] array2 = new int[10][2];
        System.out.println("multi layer array2 length = " + array2.length);

        System.out.println();

        //4. Sort and BinarySearch

        int[] arr3 = {1, 4, 56, 12, 56, 78, 11, 0, 123, 566};
        sort(arr3, 0, arr3.length-1);

        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 56 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 56) );
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 1 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 1) );
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 101 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 101) ); //-9
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of 4 from 1 to 3 is " + Arrays.binarySearch(arr3, 1, 3, 4) ); // 2
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of 12 from 1 to 3 is " + Arrays.binarySearch(arr3, 1, 3, 12) ); // -4

    }
}
