package com.ams.train;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Step32MultiThreadThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPool= Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int taskNum = i;

            threadPool.execute(() -> {

                System.out.println("Thread num " + Thread.currentThread().getName() + " ; taskNum = " + taskNum);
            });
        }

        threadPool.shutdown();
    }
    /*
    *
        Thread num pool-1-thread-1 ; taskNum = 0
        Thread num pool-1-thread-2 ; taskNum = 1
        Thread num pool-1-thread-1 ; taskNum = 3
        Thread num pool-1-thread-3 ; taskNum = 2
        Thread num pool-1-thread-1 ; taskNum = 5
        Thread num pool-1-thread-2 ; taskNum = 4
        Thread num pool-1-thread-2 ; taskNum = 8
        Thread num pool-1-thread-1 ; taskNum = 7
        Thread num pool-1-thread-3 ; taskNum = 6
        Thread num pool-1-thread-2 ; taskNum = 9
    * */
}
