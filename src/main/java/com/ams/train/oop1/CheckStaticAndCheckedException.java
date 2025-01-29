package com.ams.train.oop1;


// статический класс просто так не дает объявить
// static not allowed here
//public static class CheckStaticAndCheckedException {
//    static void getText(){
//    }
//}

public class CheckStaticAndCheckedException {

    public static void main(String[] args) {

        // Проверка использования общего каунтера для всех экземпляров класса StaticA
        StaticA sa1 = new StaticA();
        sa1.counter = 10;

        StaticA sa2 = new StaticA();
        sa2.counter = sa2.counter + 1;

        System.out.println("sa2.counter = " + sa2.counter);
        System.out.println("sa1.counter = " + sa1.counter);
        //sa2.counter = 11
        //sa1.counter = 11


        // Проверка "сокрытия" статического метода в классе наследнике StaticB
        StaticA sa = new StaticB();
        sa.print();
        // StaticA !


        // перехватываем checked-исключение из static-секции
        try {
            new StaticException();
        }catch (ExceptionInInitializerError e){
            Throwable tr = e.getCause();
            Throwable tr1 = tr.getCause();

            if (tr1 instanceof java.io.FileNotFoundException){
                System.out.println("tr1 instanceof FileNotFoundException");
                e.printStackTrace();
            }else{
                System.out.println("tr1 NOT instanceof FileNotFoundException");
            }
        }
    }
}
