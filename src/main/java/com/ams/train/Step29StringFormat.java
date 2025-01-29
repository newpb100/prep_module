package com.ams.train;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Formatter;
import java.util.IllegalFormatCodePointException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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

    /**
     *  Перехват ожидаемых исключений в JUnit5
     *  https://habr.com/ru/articles/591305/
     *
     *  Перегруженный метод
     *  static <T extends Throwable>T assertThrows(Class<T> expectedType, Executable executable)
     *
     * Если в блоке не было генерировано исключение, executable, то assertThrows() вернет FAIL.
     *
     * Если исполняемый код вызывает исключение любого другого типа, то результат теста будет FAIL.
     *
     * И даже если исполняемый код не вызывает никаких исключений, результат теста тоже будет FAIL.
     *
     * Если мы ожидаем, IllegalArgumentException и тест выдает ошибку NumberFormatException, вывод будет PASS
     * потому что NumberFormatException расширяет (является потомком) класса IllegalArgumentException.
     *      ....
     *        java.lang.IllegalArgumentException
     *                java.lang.NumberFormatException
     *
     *  Соответственно, если мы передадим Exception.class в качестве ожидаемого типа исключения, любое исключение,
     *  выброшенное из исполняемого блока, сделает результат assertion равным PASS, поскольку Exception является супертипом для всех исключений.
     *
     *  В JUnit4 для проверки исключений используется рул ExpectedException
     * */
    @Test
    public void whenIllegalCodePointForConversion_thenError() {
        // String s = String.format("The valid unicode character: %c", 0x11FFFF);
        // в этом месте возникает
        // java.util.IllegalFormatCodePointException: Code point = 0x11ffff

        IllegalFormatCodePointException thrown = Assertions.assertThrows(IllegalFormatCodePointException.class, () -> {
            String s = String.format("The valid unicode character: %c", 0x11FFFF);

            // на https://www.baeldung.com/java-string-formatter
            // зачем-то добавляют в пример еще эти 2 строки, хотя строка выше уже вызовет IllegalFormatCodePointException
            // String s = String.format("The valid unicode character: %c", 0x11FFFF);
            // assertEquals("The valid unicode character: Ā", s);
        });

        System.out.println("Message in thrown object : " + thrown.getMessage());

        // System.out.println("Несмотря на то, что символ нелегальный, можем попробовать его распечатать (char)0x11FFFF : " + (char)0x11FFFF +
        //                  " , а если через Character.toChars(0x11FFFF) : " + Character.toChars(0x11FFFF));
        // не получилось
        // java.lang.IllegalArgumentException: Not a valid Unicode code point: 0x11FFFF

        // кстати, проверка на валидность кодпоинта, видимо на причастность его к BMP
        int cc = 0x11FFFF;
        if (!Character.isValidCodePoint(cc)) {
            System.out.println("invalid code point 0x11FFFF");
        }
    }

    @Test
    public void whenLegalCodePointForConversion() {
        // Если исключение не будет обнаружено, тогда тест упадет
        // см. ниже
        // org.opentest4j.AssertionFailedError: Expected java.util.IllegalFormatCodePointException to be thrown, but nothing was thrown.

        Assertions.assertThrows(IllegalFormatCodePointException.class, () -> {
            String s = String.format("The valid unicode character: %c", 0x11);

        });
    }


}
