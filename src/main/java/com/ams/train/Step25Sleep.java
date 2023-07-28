package com.ams.train;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Step25Sleep {

    public static void main(String[] args) throws InterruptedException {
        var dt = new Date();

        System.out.println("2 секунды");
        Thread.sleep(2000);

        System.out.println("500 микросекунд");  // 0.5 миллисекунды
        int microsToNanos = 500 * 1000;
        Thread.sleep(0, microsToNanos);

        System.out.println("500 микросекунд через TimeUnit"); // 0.5 миллисекунды
        TimeUnit.MICROSECONDS.sleep(500);

        var dt1 = new Date();
        System.out.println("total time (ms): " + (dt1.getTime() - dt.getTime()));

        // total time (ms): 2030
        // 2019
        // 2009
        // ... задержки в районе 1 или нескольких мс не заметны , разброс выполнения этого кода в несколько десятков мс


    }
}
