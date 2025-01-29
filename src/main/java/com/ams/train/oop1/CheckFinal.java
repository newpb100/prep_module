package com.ams.train.oop1;

public class CheckFinal {

    //final int a;                          // final-поле надо инициализировать сразу или в конструкторе

    void doSome(boolean b){
        final int a;                        // внутри метода final-переменную можно инициализировать не сразу

        if (b) {
            a = 1;
        }else{
            a = 2;
        }

        final int[] arr_int = {1,2,3,4,5};
        arr_int[0] = 2;                     // нельзя менять ссылку у final переменной ссылочного типа, но можно менять само значение, на кот. ведет ссылка
        // arr_int = new int[7];            // cannot assign to final..
    }

}
