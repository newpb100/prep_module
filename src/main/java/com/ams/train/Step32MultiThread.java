package com.ams.train;

import com.ams.train.supply.MyThread;
import com.ams.train.supply.MyThread2;

import static java.lang.Thread.sleep;

public class Step32MultiThread {

    public static void main(String[] args) {

        // Пример 1 создание потоков на основе MyThread extends Thread
        System.out.println();
        String[] str_arr = {"Германия", "Россия", "Франция", "Испания", "Сербия"};
        int[] ages_arr = {1000, 2000, 3000, 4000};

        MyThread t1  = new MyThread("Сочи", "Москва", "Питер", "Краснодар", "Саратов");
        MyThread t2  = new MyThread(str_arr);
        t1.start();
        t2.start();

//        MyThread t3  = new MyThread(1, 2, 3, 4);
//        MyThread t4  = new MyThread(ages_arr);
//        t3.start();
//        t4.start();

    }

}
