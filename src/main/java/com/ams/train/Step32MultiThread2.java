package com.ams.train;

public class Step32MultiThread2 {

    public static void main(String[] args) {


        // Пример 2 создание потока напрямую из функционального интерфейса Runnable (содержит 1 абстрактный метод run())
        /*
        *	class MyRunnable implements Runnable {
				public void run() {
					System.out.println("This is a new thread.");
				}
			}
			public class RunnableExample {
				public static void main(String[] args) {
					MyRunnable myRunnable = new MyRunnable();
					Thread thread = new Thread(myRunnable);
					thread.start();
				}
			}
        *
        * */
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A thread created directly from functional interface Runnable");
            }
        });
        t3.start();


        // Пример 3 создания потоков с инициализаций в виде лямбда-выражения
        System.out.println();
        System.out.println("Простой пример создания потоков с инициализаций в виде лямбда-выражения");

        Runnable run1 = () -> {
            System.out.println("Created in lamda-exression");
        };
        Thread tr1 = new Thread(run1);
        tr1.start();

        for (int i = 0; i < 5; i++) {
            final int threadNum = i;

            Thread tr2 = new Thread(() -> {
                System.out.println("this is thread num = " + threadNum);
            });
            tr2.start();
        }
        /**
         this is thread num = 1
         this is thread num = 0
         this is thread num = 4
         this is thread num = 2
         this is thread num = 3

         Process finished with exit code 0
         */
    }
}
