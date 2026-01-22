package com.ams.train;

import org.junit.jupiter.api.Test;

import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Step29StringFormat {


    public static void doStringFormat() {
    }

    @Test
    public void checkFormat(){
        System.out.println(String.format("Привет, %s, твой результат: %d", "Алиса", 85));

        // похожим образом работает
        System.out.printf("Привет, %s, твой результат: %d", "Алиса", 85);


        // или еще можно так
        // String aaa = "Привет, %s, твой результат: %d".formatted("Алиса", 85);
        // но ругается Set language level to 13..
        // у меня нет такого уровня, есть 11, 17
        // попробовал переключиться на уровень 17 (для проекта и для одноименного модуля)
        // 1. Source root is duplicated in module ... error in IntelliJ Idea
        //    >
        //          точнее надо описывать..
        //    Ошибка при нажатии на Apply в Project Structure > Modules
        //    Снес модуль prep_module - не осталось модулей вообще
        //    Apply отработал, но развалилась структура папок, пришлось переимпортировать модуль - prep_module
        //    сломались ссылки на junit классы, такое ощущение, что перестал видеть JUnit5
        //    пришлось переподключать депенденси на JUnit5 - увидел
        //    теперь удалось выставить уровень 17
        // 2.
        // java: java.lang.NoSuchFieldError: Class com.sun.tools.javac.tree.JCTree$JCImport does not have member field 'com.sun.tools.javac.tree.JCTree qualid'
        // пришлось откатиться на 11 уровень
    }

    /**
     *  Ширина и флаги для форматирования вывода
     * */
    @Test
    public void whenSpecifyFlag_thenGotFormattedString() {
        String s = String.format("Without left justified flag: %5d", 25);
        assertEquals("Without left justified flag:    25", s);

        s = String.format("With left justified flag: %-5d", 25);
        // assertEquals("With left justified flag: 25", s);
        // ломается c org.opentest4j.AssertionFailedError:
        // т.к. в выводе 25 выравнивается по левому краю, и после должно следовать еще 3 символа, т.к. задано шириной 5

        assertEquals("With left justified flag: 25   ", s);   // PASS
    }

    @Test
    public void whenCreateFormatter_thenFormatterWithAppendable() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("I am writting to a %s Instance.", sb.getClass());
        // получается тут мы переписываем метод toString() объекта StringBuilder, чтобы он
        // выводил нам форматированный вывод, который мы определили в объекте-форматтере, который ссылает на объект StringBuilder

        assertEquals(
                "I am writting to a class java.lang.StringBuilder Instance.",
                sb.toString());
    }
}
