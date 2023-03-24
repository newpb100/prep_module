package com.ams.train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step03Readers {

    public static void doStep03Readers() {
        var in1 = System.in;


        try {
            System.out.println("Print smth for get it with System.in.read() : ");
            int x = 0;

            while (true) {
                x = System.in.read();
                System.out.println("got x-byte from System.in : " + x);
                if (x == 10){ // выход на переносе строки
                    break;
                }
                //Я
                //208
                //175
                //10
            }

            System.out.println("Print smth for get it with InputStreamReader : ");
            var is = new InputStreamReader(System.in);
            x = is.read();
            System.out.println("got x from InputStreamReader : " + x);
                //Я
                //1071

            System.out.println("Print smth for get it with BufferedReader : ");
            var br = new BufferedReader(new InputStreamReader(System.in));
            x = br.read();
            System.out.println("got x from BufferedReader : " + x);
                //Я
                //1071

            System.out.println("Print string for get it with BufferedReader : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            String xstr = br.readLine();
            System.out.println("got xstr-string from BufferedReader : " + xstr);


        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
