package com.ams.train.supply;

import com.ams.train.Step32MultiThreadInterrupt;

public class MyThread2 extends Thread {

    @Override
    public void run() {

        boolean interrupted1 = false;

        System.out.printf("%s started... \n", Thread.currentThread().getName());

        while (!interrupted1) {

            interrupted1 = Thread.interrupted();
            System.out.println("interrupted1 = " + interrupted1);

//            Если тут будет такой слип, то установка флага в true слетает..
//            видимо потому что тут происходит генерация исключения, которое ломает установку внутреннего флага Thread.interrupted в тру и оно остается false
//            и цикл продолжается дальше
//            try {
//                sleep(50);
//            } catch (InterruptedException e) {
//                //throw new RuntimeException(e);
//            }

            // вот такой подход приводит автор на
            // https://habr.com/ru/articles/164487/
            // т.е. у него явно используется return т.е. у него тоже внешний вызов interrupt при наличии sleep ломает логику с проверкой флага
            // и приходится явно вызывать return из catch секции
            /*
            *   Чел в комментах раскрывает:
            *   "И еще один момент — InterruptedException нежелательно поглощать без обработки (пустой catch блок),
            *   его нужно либо повторно генерировать, либо заново выставить флаг методом interrupt(), чтобы еще «прервать» текущий поток.
            *   Иначе другие методы в стеке вызовов не узнают, что было прерывание."
            *   ...
            *   "Допустим вы в рамках одного потока поймали InterruptedException, например, в методе sleep и поглотили его без выставления флага.
            *    Если дальше по коду (или выше по стеку) стоят проверки флага Interrupted — то они не сработают"
            *
            *  */

            try {
                sleep(50);
                Step32MultiThreadInterrupt.Counter++;
            } catch (InterruptedException e) {
                interrupted1 = Thread.interrupted();
                System.out.println("interrupted1 in try-catch section = " + interrupted1);
                return;

                // На джавараше приводят решение:
                // Выше за пределами try-catch объявляют
                // Thread current = Thread.currentThread();
                // и потом в секции catch делают вызов interrupt()
                // current.interrupt();
                // т.е. по сути перевыставляют флаг прерывания потока, которое "поглотило" исключение во время sleep()
            }

        }

        // Второй вариант цикла
        // в этом случае используем ссылку на объект нашего потока и проверяем флаг без его сброса

        // while (!Thread.currentThread().isInterrupted()) {
            // Код потока
        //}

    }
}
