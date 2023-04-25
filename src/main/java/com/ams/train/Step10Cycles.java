package com.ams.train;

public class Step10Cycles {

    public static void main(String[] args) {

        int i = 0;
        // 1. For with bool
        for(boolean flag=true; flag;){
            i++;
            System.out.println("cycle i = " + i);
            if (i == 5){
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


        // foreach
        String[] cars = {"audi", "haval", "lada", "ford"};

        for(String s: cars){
            System.out.println("car is " + s);
        }


    }
}
