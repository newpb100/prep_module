package com.ams.train;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Step03Scanner {
    public static float doStep03() {

        // Scanner
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Print ur name: ");
        String name = sc.nextLine();
        System.out.println("Print ur age: ");
        int age = sc.nextInt();
         */

        String inputStr = "100;2,0;200";
        Scanner sc = new Scanner(inputStr);
        int a3 = 0;
        sc.useDelimiter(";");

        while (true) {
            if (sc.hasNextInt()) {
                 a3 = sc.nextInt();
                System.out.println("got " + a3);
            }else{
                System.out.println("data mismatch!");
                break;
            }
        }

        float a4 = sc.nextFloat();
        System.out.println("scanner res : " + (a3 + a4));

        sc.close();

        return (a3 + a4);


    }
}
