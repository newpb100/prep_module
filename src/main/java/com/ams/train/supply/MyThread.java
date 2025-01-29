package com.ams.train.supply;

public class MyThread extends Thread {

    String[] names;
    int[] ages;

    public MyThread(String... names) {
        this.names = names;
    }

    public MyThread(int... ages) {
        this.ages = ages;
    }

    public void run() {

        if (names != null) {

            System.out.println("MyThread");
            System.out.println("Print names");
            System.out.println("---------------------");

            for (String i : names) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i + " ; ");
            }
        }

        if (ages != null) {

            System.out.println();
            System.out.println("Print ages");
            System.out.println("---------------------");

            for (int i : ages) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i + " ; ");
            }
        }
    }
}
