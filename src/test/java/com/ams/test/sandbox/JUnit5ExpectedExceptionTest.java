package com.ams.test.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.util.IllegalFormatCodePointException;

public class JUnit5ExpectedExceptionTest {

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

        //    В одном из примеров..используют и без присвоения.
        //    Assertions.assertThrows(NumberFormatException.class, () -> {
        //      Integer.parseInt("One"); // Throws NumberFormatException
        //    });

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

    //@Disabled("Check Disabled annotation")
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
