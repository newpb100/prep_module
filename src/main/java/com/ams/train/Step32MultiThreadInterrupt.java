package com.ams.train;

import com.ams.train.supply.MyThread2;

import static java.lang.Thread.sleep;

public class Step32MultiThreadInterrupt {

    public static volatile int Counter = 0;

    public static void main(String[] args) {

        Thread tr4 = new MyThread2();
        tr4.start();
        try {
            sleep(100);
            if (Counter == 1){
                Counter += 10;
            }
            sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        tr4.interrupt();
        // interrupted1 = true                          (если в потоке НЕ используется sleep)
        // interrupted1 in try-catch section = false    (если в потоке используется sleep)

        System.out.println("tr4.isInterrupted() = " + tr4.isInterrupted());
        // tr4.isInterrupted() = true

        System.out.println("Counter = " + Counter);

        // System.out.println("Thread.interrupted() = " + Thread.interrupted());
        // вызов тут этого метода влияет на предыдущий оператор.. он может начать возвращать false..!

        // но даже без него по неведомым причинам tr4.isInterrupted() может иногда возвращать false..
        // такое ощущение, что он просто не успевает иногда выставиться в true (т.е на него влияет верхний слип sleep(50); чем он меньше, тем больше вероятность такого глюка)

    }
}
