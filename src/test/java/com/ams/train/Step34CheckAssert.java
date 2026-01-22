package com.ams.train;

import com.ams.train.supply.SimpleClass;

import static org.junit.Assert.assertEquals;

public class Step34CheckAssert {

    public static void main(String[] args) {

        int age = 15;

        // assert age >= 18 : "Несовершеннолетний!";
        // чтобы сработало, необходимо включить опцию -ea в параметрах JVM (Run > Run Configuration)
        // и тогда
        // err! Exception in thread "main" java.lang.AssertionError: Несовершеннолетний!


        // assertEquals(18, age);
        // кстати, этот метод генерит тот же тип исключения - AssertionError
        // err! Exception in thread "main" java.lang.AssertionError: expected:<18> but was:<15>

        SimpleClass sc = new SimpleClass();
        sc.doSome();
        // несмотря на то, что проверка внутри вызываемого класса
        // err! Exception in thread "main" java.lang.AssertionError: AssertionError в вызываемом классе SimpleClass

        System.out.println("Привет, мир!");
    }
}
