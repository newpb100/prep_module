package com.ams.train;

import com.ams.train.supply.SampleAbstract;
import com.ams.train.supply.SampleInterface;

public class Step33CheckAnonAndAbstract {
    static SampleAbstract v1;   // так как обращаемся из статического контекста, поле д.б. статик
    static SampleInterface i1;

    private static int a1;


    public static void main(String[] args) {

        //SampleAbstract v1;

        // получается тут создаем анонимный класс в котором сразу реализуем класс SampleAbstract, да еще и расширяем его..
        v1 = new SampleAbstract(){
                // кстати, тут не совсем понятно, почему выше a1 должна быть объявлена как static
                // чтобы избежать 'non-static field cannot be referenced from a static context'
                // про v1 и v2 более менее понятно, что они появляются прям в мейне..
                // но a1, она же уже находится за оператором new(), внутри контекста созданного объекта
                // или что , если что-то находится внутри статического метода, неважно просто переменные или новые объекты, все будет иметь стат. контекст??
                // ответ прост:
                // любая переменная за пределами main() и НЕ статик БУДЕТ существовать только когда будет создан класс Step33CheckAnonAndAbstract
                // неважно откуда мы к ней обращаемся внутри - изнутри new SampleAbstract() или до него
                // один из обходных путей: прям в мейне создать new Step33CheckAnonAndAbstract() и обращаться к переменной
                int a = a1;

               // @Override
                public void doSomething(){
                    System.out.println("doSomething from new SampleAbstract()");
                }

                public void doSomething2(){
                    System.out.println("doSomething2 from new SampleAbstract()");
                }

        };

        v1.doSomething();

        // v1.doSomething2();   вот так нельзя.. срабатывает только если написать: var v1 ,
        // а почему тогда дает без проблем определить внутри анонимного класса  doSomething2() , если потом не дает его использовать?
        // не получается и если v1 объявить внутри метода main()
        // что тогда делает объявление var???

        // вот так тоже можно вызвать doSomething2()
        new SampleAbstract(){
            // @Override
            public void doSomething(){
                System.out.println("doSomething from new SampleAbstract()");
            }

            public void doSomething2(){
                System.out.println("doSomething2 from new SampleAbstract() without assignment operation");
            }
        }.doSomething2();


        SampleInterface i1 = new SampleInterface(){
            @Override
            public void doSomethingInInterface() {
                System.out.println("doSomethingInInterface from new SampleInterface()");
            }

            public void doSomethingInInterface2(){
                System.out.println("doSomethingInInterface2 from new SampleInterface()");
            }
        };

        i1.doSomethingInInterface();
        // i1.doSomethingInInterface2();
        // i1.doSomethingInInterface2();  также нет доступа

    }
}
