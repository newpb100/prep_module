package com.ams.train;

import javax.sound.midi.Soundbank;

public class Step10Cycles {
    public static final String a = "";

    public static void main(String[] args) {

        // Области видимости
        System.out.println("Области видимости, значения итератора перед входом в цикл и после выхода из него");
        int i = 0;                          // i будет видна в заголовке цикла, внутри него и за пределами
        for (i = 0; i < 1000; i++) {
            int j = 0;
        }
        System.out.println(i);              // i = 1000
        //System.out.println(j);            // err! Cannot resolve symbol j , за пределами цикла ее НЕ видно

        for (int i1 = 0; i1 < 1000; i1++) {
            int j = i1;
        }
        //System.out.println(i1);            // err! Cannot resolve symbol i1 , за пределами цикла ее НЕ видно


        System.out.println();
        System.out.println("Инициация k-итератора за пределами цикла");
        int k = 0;
        for (; k < 4; k++) {
            if (k == 13) break;
        }
        System.out.println("k = " + k);


        System.out.println();
        System.out.println("Примеры бесконечных циклов с прерыванием внутри");
        int i2 = 0;
        // 1. For with bool
        for(boolean flag=true; flag;){
            i2++;
            System.out.println("cycle i2 = " + i2);
            if (i2 == 5){
                flag = false;
            }
        }
        // 2. For infinity
        for(; true;) {
            i++;
            if (i % 34 == 0){
                System.out.println("i % 34 == 0 for i " + i);
                break;
            }
        }


        // 3. For with continue
        for (i = 1; i <= 10; i++) {
            if ( (i % 7) == 0) {
                continue;
            }
            System.out.print(i + " ");
        }

        System.out.println();


        // 4. For with step more than 1
        for (i = 1; i <= 10; i+=2) {
            if ( (i % 7) == 0) {
                continue;
            }
            System.out.print(i + " ");
        }


        // 5. Calc factorial
        System.out.println();
        int num = 12;
        int fact = 1;
        for (i = 1; i <= num; i++){
            fact = fact * i;
        }
        System.out.println("factorial of "+ num + " = " + fact);


        // 6. Embedded cycles
        int x = 10;
        int y = 5;
        for (i = 1; i <= y; i++){
            for (int j = 1; j <= x; j++){
                System.out.print('А');
            }
            System.out.println();
        }

        for (i = 0; i < 7; i++){
            int starCount = 7 - i;
            for (int j = 0; j < starCount; j++)  // в отличие от i, переменную j снова нужно объявлять
                System.out.print("*");
            System.out.println();
        }


        // 7. foreach
        String[] cars = {"audi", "haval", "lada", "ford"};

        // String s = "";
        // переменная внутри скобок цикла for НЕ является изолированной
        // в ее область видимости входит и то, что лежит за ее пределами
        // поэтому если разкомментить String s = ""; в скобках s будет подсвечена, т.к. s уже defined in the scope
        for(String s: cars){
            System.out.println("foreach: car is " + s);
        }
        // foreach classic alternative
        for (i = 0; i < cars.length ; i++){
            System.out.println("alternative: car is " + cars[i]);
        }

        System.out.println();


        // 8. for for multilayer arrays
        int[][] array = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for (i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length ; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


        // 9. Trick
        //for (i = 0 ; i > -1; i++){
        //    if (i % 1e7 == 0) System.out.println(i);
        //}
        //System.out.println("will this string reached? i = " + i); // will this string reached? i = -2147483648

        System.out.println();


        // 10. More than 1 counter/argument
        int j;
        for (i = 0, j = 10; i != j ; i++, j--){
            System.out.println("i = " + i + " ; j = " + j);
        }

        int a = 0;
        int b = 1;
        int c = 0;
        for (i = 0; i < 5 ; i++ , a += 2, b *=10 , c--){
            System.out.println(i + " ; a = " + a + " ; b = " + b + " ; c = " + c);
        }

        // 10. Example for debug
        /*
        for (i = 0, j = 10; i != j ; i++, j-=2){
            System.out.println("i = " + i + " ; j = " + j);

            if (j < i){
                throw new RuntimeException("now j is less than i");
            }
        }
         */

        //10.2
        /*
        int[] ar = new int[10];
        ar[11] = 2;

         */

        System.out.println();
        System.out.println("Долг по практике");
        i = 0;
        int[] arr224 = new int[5];
        while (i++ < arr224.length){
            System.out.println(i);      //1, 2, 3, 4, 5
        }
        i = 0;
        System.out.println();
        while (++i < arr224.length){
            System.out.println(i);      //1, 2, 3, 4
        }

    }
}
