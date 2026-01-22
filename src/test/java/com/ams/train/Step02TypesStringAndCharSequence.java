package com.ams.train;

import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class Step02TypesStringAndCharSequence {

    public static void main(String[] args) {

        // String и CharSequence (объявление и приведенеие типов)
        System.out.println();
        System.out.println("String и CharSequence (объявление и приведенеие типов)");

        String str11 = "simple String";
        CharSequence cs = "simple CharSequence";
        CharSequence csFromStrBuffer = new StringBuffer("baeldung 1");
        CharSequence csFromStrBuilder = new StringBuilder("baeldung 2");

        System.out.println(cs);
        System.out.println(csFromStrBuffer);
        System.out.println(csFromStrBuilder);

        System.out.println(str11.substring(1,3));

        cs = str11;                         // строка присваивается, происходит неявное преобразование

        //cs.substring()                    // err! в исходном интерфейсе этого метода нет..

        //str11 = cs;                       // err! а вот обратная операция не работает, ожидаемо, вспоминаем кто кого расширяет..
        // требуется преобразование, варианты:
        str11 = String.valueOf(cs);
        str11 = cs.toString();
        str11 = (String)cs;

        // Для явного (String) внимание:
        // str11 = (String)csFromStrBuffer;     // err! class java.lang.StringBuffer cannot be cast to class java.lang.String...
        // csFromStrBuffer переменная типа CharSequence содержит сейчас объект типа StringBuffer
        // для такого случая, вместо ЯВНОГО преобразования надо использовать НЕЯВНОЕ через toString()
        str11 = csFromStrBuffer.toString();
        System.out.println("Неявное преобразование из StringBuffer, которое было в переменной cs(CharSequence) в String : " + str11);
        // OK

        // но наиболее предпочтительным является способ через valueOf() , т.к. в этом случае будет корректно обработан случая когда переменная = null
        csFromStrBuffer = null;
        // str11 = csFromStrBuffer.toString();  // err!
        str11 = String.valueOf(csFromStrBuffer);
        System.out.println("str11 with null value prints :" + str11);
        // OK
        assertEquals("null", str11);
        // OK


        // Сравнение String строк
        System.out.println();
        System.out.println("Сравнение String строк");

        String string1 = "string-baeldung";
        String string2 = "string-baeldung";

        assertEquals(string1, string2);               // JVM видит, что пуле строк это один литерал, поэтому переменные будут равны
        // true
        System.out.println("string1.equals(string2) = " + string1.equals(string2));
        // true

        System.out.println();
        int firstAddress = System.identityHashCode(string1);
        int secondAddress = System.identityHashCode(string2);
        // identityHashCode()   метод, который возвращает хеш-код заданного объекта.
        // Он вычисляет хеш, основываясь непосредственно на адресе объекта в памяти JVM, что обеспечивает уникальность и согласованность идентификатора.

        System.out.println("firstAddress                = " + firstAddress);
        System.out.println("secondAddress               = " + secondAddress);
        //firstAddress                = 992136656
        //secondAddress               = 992136656

        // Изменение строки порождает новый объект в памяти и у него будет новый хэш
        string2 += " 2";

        secondAddress = System.identityHashCode(string2);

        System.out.println("secondAddress after +=2     = " + secondAddress);
        //secondAddress after +=2     = 166239592

        // Однако, если мы создаём экземпляры объектов String с помощью конструктора new String(""), даже если их значения одинаковы,
        // каждый объект String имеет свою область памяти. Следовательно, это разные объекты
        String string3 = new String("string-baeldung");
        assertNotSame(string1, string3);
        // they NOT same? true
        // но при сравнении по содержимому, неважно как там строки инициировались через new() или как переменные
        System.out.println("string1.equals(string3) = " + string1.equals(string3));
        // they ARE same? true!

        // для лексикографического сравнения у String есть compareTo
        System.out.println("Лексикографическое сравнение String");
        System.out.println("string1.compareTo(string3) = " + string1.compareTo(string3));
        // 0
        System.out.println("string1.compareTo(string2) = " + string1.compareTo(string2));
        //"string-baeldung"
        //"string-baeldung 2"
        // a value less than 0 if this string is lexicographically less than the string argument;
        // -2
        // the shorter string lexicographically precedes (предшествует) the longer string.
        // In this case, compareTo returns the difference of the lengths of the strings -- that is, the value:
        // this.length()-anotherString.length()



        // Сравнение CharSequence (и String)
        System.out.println();
        System.out.println("Сравнение CharSequence (и String)");
        cs = "baeldung 3";
        string3 = "baeldung 3";
        string2 = "baeldung 2";

        System.out.println("cs(CharSequence) compare with string3(String) : " + CharSequence.compare(cs, string3));  // несмотря на то, что 2-м параметром шла стринга, сравнение валидно
        //0
        //the value 0 if the two CharSequence are equal;
        System.out.println("cs(CharSequence) compare with string2(String) : " + CharSequence.compare(cs, string2));  // "baeldung 3" и "baeldung 2"
        // 1
        // positive integer if the first CharSequence is lexicographically greater than the second.


        System.out.println();
        System.out.println("Проверка на пустые значения");
        cs = "";

        System.out.println("cs содержит пустую строку, проверка      : " + cs.isEmpty());    // можно проверять только на пустые строки
        cs = null;
        // System.out.println("cs содержит null, проверка               : " + cs.isEmpty());
        // err! Cannot invoke "java.lang.CharSequence.isEmpty()" because "cs" is null...
        // вот почему нужен StringUtils

        System.out.println("StringUtils.isEmpty(cs), cs содержит null, проверка                     : " + StringUtils.isEmpty(cs));
        cs = "";
        System.out.println("StringUtils.isEmpty(cs), cs содержит пустую строку, проверка            : " + StringUtils.isEmpty(cs));

        // аналогично со строками, если надо проверять и на пустую строку и на null то через StringUtils
        string1 = null;
        System.out.println("StringUtils.isEmpty(string1), string1 содержит null, проверка           : " + StringUtils.isEmpty(string1));
        string1 = "";
        System.out.println("StringUtils.isEmpty(string1), string1 содержит пустую строку, проверка  : " + StringUtils.isEmpty(string1));



        // Форматирование строк
        /**
         *  Форматирование уже есть на уровне String класса
         *  тема поднимается в Step29StringFormat
        * */
        System.out.println();
        System.out.println("Форматирование строк");
        String.format("Привет, %s, твой результат: %d", "Алиса", 85);
    }
}
