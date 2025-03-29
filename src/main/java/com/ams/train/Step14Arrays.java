package com.ams.train;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Step14Arrays {

    public static void main(String[] args) {

        // 1. Simple
        System.out.println();
        System.out.println("Простые примеры инициализации массива");

        int[] a = new int[10];
        int[] b;

        b = a;

        a[9] = 122;
        System.out.println("b[9] = " + b[9]);
        // b[9] = 122

        int[] simpArr = {1,2,3,4,5,6,7};

        // Печать
        System.out.println(simpArr);    // в отличие от списков (List) массивы нельзя так распечатывать до значений элементов
        // [I@59f95c5d
        System.out.println(Arrays.toString(simpArr));
        // [1, 2, 3, 4, 5, 6, 7]
        // Печать любого массива с помощью стримов и лямбда-выражений
        System.out.println("Печать массива примитивов с помощью стримов и лямбда-выражений:");
        Arrays.asList(simpArr).stream().forEach(System.out::println);
        // [I@59f95c5d      - не может распечатать массив примитивов, а вот массив ссылочных типов - сможет. Вынесено в задачник


        // 2. Default values
        System.out.println();
        boolean[] bb = new boolean[3];
        for (int i = 0; i < bb.length; i++) {
            System.out.print(bb[i] + " ; ");
        }
        System.out.println();
        //false ; false ; false ;

        int[] ii = new int[3];
        for (int i = 0; i < ii.length; i++) {
            System.out.print(ii[i] + " ; ");
        }
        System.out.println();
        // 0 ; 0 ; 0 ;

        double[] dd = new double[3];
        for (int i = 0; i < dd.length; i++) {
            System.out.print(dd[i] + " ; ");
        }
        System.out.println();
        // 0.0 ; 0.0 ; 0.0 ;

        String[] ss = new String[3];
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i] + " ; ");
        }
        System.out.println();
        // null ; null ; null ;


        // Multilayer(2x) array
        System.out.println();
        System.out.println("Инициализация двумерного массива");
        int[][] array = {
                {1,2,3,3},
                {4,5,6,6},
                {7,8,9,10}
        };
        System.out.println("multi layer array length = " + array.length);

        int[][] array2 = new int[10][2];
        System.out.println("multi layer array2 length = " + array2.length);

        Object[][] myObj = new Object [][] {
                {1, 2, 3, 5},
                {1},
                {"ssstttrrr", true}
        };
        System.out.println("myObj[0][1] = " +  myObj[0][1]);


        //Sort, toString and BinarySearch
        System.out.println();
        System.out.println("Сортировки и поиск");

        int[] arr3 = {1, 4, 56, 12, 56, 78, 11, 0, 123, 566};
        int[] arr31 = Arrays.copyOf(arr3, arr3.length);

        Arrays.sort(arr3, 0, arr3.length-1);

        Arrays.sort(arr31,0,4);
        System.out.println("partly sorted array (from 0 to 4) arr31 = " + Arrays.toString(arr31));

        // -9, "-" значит, что элемента нет в массиве, 9 получено как (-8 (куда бы он был вставлен) - 1 = -9 )
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 56 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 56) );
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 1 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 1) );
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of element 101 is " + Arrays.binarySearch(arr3, 0, arr3.length-1, 101) ); //-9
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of 4 from 1 to 3 is " + Arrays.binarySearch(arr3, 1, 3, 4) ); // 2
        System.out.println("sorted arr3 = " + Arrays.toString(arr3) + " and index of 12 from 1 to 3 is " + Arrays.binarySearch(arr3, 1, 3, 12) ); // -4


        //copyOf,  copyOfRange, Equals
        //arr3             = [0, 1, 4, 11, 12, 56, 56, 78, 123, 566]

        int[] arr4 = Arrays.copyOf(arr3, arr3.length);
        int[] arr5 = Arrays.copyOfRange(arr3, 3, 5);
        int[] arr8 = Arrays.copyOfRange(arr3, 5, 15);
        System.out.println();
        System.out.println("arr3              = " + Arrays.toString(arr3));
        System.out.println("arr4              = " + Arrays.toString(arr4));
        System.out.println("arr5 (range 3,5)  = " + Arrays.toString(arr5));   //11, 12 - включая левую границу и не включая правую
        System.out.println("arr8 (range 5,15) = " + Arrays.toString(arr8));  // [56, 56, 78, 123, 566, 0, 0, 0, 0, 0]

        System.out.println();
        System.out.println("arr3 equals arr4  ? " + Arrays.equals(arr3, arr4));  // true
        System.out.println("arr3.equals(arr4) ? " + arr3.equals(arr4));          // false , хоть и equals, но в таком контексте сравнивает ссылки
        System.out.println("arr3 equals arr5  ? " + Arrays.equals(arr3, arr5));  // false

        arr3[0] = 1111;
        System.out.println();
        System.out.println("arr3 after arr3[0] = 1111; = " + Arrays.toString(arr3));
        System.out.println("arr4                       = " + Arrays.toString(arr4));


        int[] arr6;
        arr6 = Arrays.copyOf(arr3, 3);
        System.out.println();
        System.out.println("arr6 got only 3 values from arr3,         arr6 = " + Arrays.toString(arr6));

        int[] arr7;
        arr7 = Arrays.copyOf(arr3, 15);
        System.out.println("arr7 requested more values that arr3 has, arr7 = " + Arrays.toString(arr7));


        // 6. Multilayer copyOf, deepToString, deepEquals, equals
        int[][] arrayMult_1 = {
                {1,2,3,3},
                {4,5,6,6},
                {7,8,9,10}
        };

        // В данном случае произойдет ! ПОВЕРХНОСТНОЕ КОПИРОВАНИЕ ! , т.е. 2-й массив будет смотреть на 1-й
        int[][] arrayMult_2 = Arrays.copyOf(arrayMult_1, arrayMult_1.length);

        System.out.println();
        System.out.println("arrayMult_1             = " + Arrays.deepToString(arrayMult_1));
        System.out.println("arrayMult_2             = " + Arrays.deepToString(arrayMult_2));

        // доказательство, что ссылки смотрят на одни и те же блоки памяти, а если это так, то смысла проводить deepEquals после такого копирования - НЕТ
        arrayMult_1[0][0] = 111;
        arrayMult_1[0][1] = 111;
        arrayMult_1[0][2] = 111;
        arrayMult_1[0][3] = 111;
        System.out.println("");
        System.out.println("arrayMult_1             = " + Arrays.deepToString(arrayMult_1));
        System.out.println("arrayMult_2             = " + Arrays.deepToString(arrayMult_2));

        System.out.println();
        System.out.println("arrayMult_1 deepEquals arrayMult_2  ? " + Arrays.deepEquals(arrayMult_1, arrayMult_2));  // true
        System.out.println("arrayMult_1 equals     arrayMult_2  ? " + Arrays.equals(arrayMult_1, arrayMult_2));      // true , но это потому что 2-й массив мы создали через Arrays.copyOf
        // если мы 2-й массив отдельно инициализируем, то equals, конечно, вернет false
        int[][] arrayMult_3 = { {1,2}, {3,4} };
        int[][] arrayMult_4 = { {1,2}, {3,4} };
        System.out.println("arrayMult_3 equals     arrayMult_4  ? " + Arrays.equals(arrayMult_3, arrayMult_4));      // false


        // 7. Full Multilayer 4-dimensions
        System.out.println();

        int[][][][] matrix;

        matrix = new int[3][][][];

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("1 ");
            matrix[i] = new int[2][][];

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(" 2");
                matrix[i][j] = new int[2][];

                for (int k = 0; k < matrix[i][j].length; k++) {
                    System.out.println("  3");
                    matrix[i][j][k] = new int[2];

                }

            }
        }

        // 8. Fill
        int[] arr_100 = {1,2,3,4,5,6};
        Arrays.fill(arr_100, 1, 4, -999);
        System.out.println();
        System.out.println("arr_100 after fill : " + Arrays.toString(arr_100));


        // 9. Modify FINAL array
        final int[] data = {1, 2, 3, 4, 5, 6};
        //data = new int[]{6, 7, 8, 9};  // err! Cannot assign a value to final variable 'data'
        data[0] = 0;                     //correct
        System.out.println("final int[] data = " + Arrays.toString(data));


    }
}
