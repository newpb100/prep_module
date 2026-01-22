package com.ams.train;

import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Step02TypesUnicode {

    public static void doStep02TypesUnicode() {

        System.out.println();
        System.out.println("--- Вывод Hex представления символов(кодпоинтов) Unicode ---");
        System.out.println("для П через String.format, 2-м аргументом должно идти целое значение, чтобы через %x быть преобразованным в hex-значение");
        // BigInteger(int signum, byte [] magnitude) конструирует BigInteger из знака и величины числа.
        // Параметры:
        // signum — знак числа (-1 для отрицательного, 0 для нуля, 1 для положительного);
        // magnitude — бинарное представление величины числа в BE-порядке (самый значительный байт находится в нулевом элементе)
        //
        // сначала покажем, что %x в format занимается преобразованием целых в hex, на вход должно идти именно целое, не строка, не массив байт
        System.out.println(String.format("0x%010X", 10));
        // 0x000000000А
        System.out.printf("0x%010X %n", 10);
        // 0x000000000А

        // Дополнительно:
        // printf() и String.format() — методы для форматирования строк, но у них разные функции.
        // printf() выводит отформатированную строку в консоль. Для этого на входе должна быть строка формата,
        // которая указывает, что печатать, и один или несколько последующих аргументов.
        // В строке формата могут быть спецификаторы преобразования (местоholders, начинающиеся с%),
        // которые указывают, как форматировать последующие аргументы функции.
        // String.format() возвращает отформатированную строку, которую можно сохранить или использовать по своему усмотрению.

        // Ниже фактически примеры того, как любую строку представить в Hex-виде
        // В таком виде будут представлены целые
        // 1
        System.out.println("П как целое десятичное");
        System.out.println(new BigInteger(1, "П".getBytes(StandardCharsets.UTF_8)));
        System.out.println(new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16BE)));
        System.out.println(new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16LE)));
        System.out.println(new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16)));
        // 2
        System.out.println("П как Hex через BigInteger.toString(radix: 16)");
        System.out.println( (new BigInteger(1, "П".getBytes(StandardCharsets.UTF_8))).toString(16) );
        System.out.println( (new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16BE))).toString(16) );
        System.out.println( (new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16LE))).toString(16) );
        System.out.println( (new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16))).toString(16) );
        // 3
        System.out.println("П как Hex через String.format ");
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_8))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16BE))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16LE))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16))));
        // 4
        System.out.println("П как Hex через Hex.encodeHexString");
        System.out.println(Hex.encodeHexString("П".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Hex.encodeHexString("П".getBytes(StandardCharsets.UTF_16BE)));
        System.out.println(Hex.encodeHexString("П".getBytes(StandardCharsets.UTF_16LE)));
        System.out.println(Hex.encodeHexString("П".getBytes(StandardCharsets.UTF_16)));

        System.out.println("для M(lat) через Hex.encodeHexString");
        System.out.println(Hex.encodeHexString("M".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Hex.encodeHexString("M".getBytes(StandardCharsets.UTF_16BE)));
        System.out.println(Hex.encodeHexString("M".getBytes(StandardCharsets.UTF_16LE)));
        System.out.println(Hex.encodeHexString("M".getBytes(StandardCharsets.UTF_16)));

        // С символами понятно , а как десятичное число закодировать в UTF16LE например?
        // - неважно десятичное/не десятичное, сначала надо получить строковое представление числа, например "16", его hex представление будет "10"
        // - а потом закодировать каждый символ, используя таблицу Unicode, и одну из схем кодирования
        System.out.println("--- Получить hex представление целого в виде строки ---");
        System.out.println(Integer.toHexString(16));
        System.out.println(Integer.toHexString(160));

        // Еще пример, представление целых в Hex-виде через String.format
        System.out.println("Представление массива целых в Hex-виде через String.format");
        byte[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        for(byte i: b){
            System.out.println(String.format("%02X", i));
        }

        // Еще один способ работы с Hex-представлениями это HexFormat, доступен c Java17
        // https://www.baeldung.com/java-hexformat
        /**
        * Можно выполнять удобные форматирования и преобразования Hex-данных: из строки в массив байт и обратно, например
        * java.util.HexFormat , доступнно только с Java17
        *
        * Методы
        * HexFormat.of()
        * hexFormat.parseHex
        * hexFormat.formatHex
        * hexFormat.toHexDigits
        *
        *
        * Строки
        * HexFormat hexFormat = HexFormat.of().withPrefix("[").withSuffix("]").withDelimiter(", ");
        * assertEquals("[48], [0c], [11]", hexFormat.formatHex(new byte[] {72, 12, 17}));
        * По умолчанию HexFormat выводит шестнадцатеричное значение в нижнем регистре.
        * Мы можем изменить это поведение, вызвав withUpperCase() при создании экземпляра HexFormat:
        * upperCaseHexFormat = HexFormat.of().withUpperCase();
        * также существует
        * withLowerCase()
        *
        *
        * byte[] hexBytes = hexFormat.parseHex("ABCDEF0123456789");
        * assertArrayEquals(new byte[] { -85, -51, -17, 1, 35, 69, 103, -119 }, hexBytes);
        *
        * String bytesAsString = hexFormat.formatHex(new byte[] { -85, -51, -17, 1, 35, 69, 103, -119});
        * assertEquals("ABCDEF0123456789", bytesAsString);
        *
        * String fromByte = hexFormat.toHexDigits((byte) 64);
        * assertEquals("40", fromByte);
        * String fromLong = hexFormat.toHexDigits(1234_5678_9012_3456L);
        * assertEquals("000462d53c8abac0", fromLong);
        *
        */


        System.out.println("--- Преобразование int к char ---");
        // https://www.baeldung.com/java-convert-int-char
        // Let’s say we have an int variable with value 7 and we want to convert it to its char counterpart '7'.
        // Simply casting it to char won’t work because this converts it to the character that’s represented in binary as 0111,
        // which in UTF-16 is U+0007 or the character 'BELL'.

        int a121 = 7;
        char a121_c = (char)a121;
        System.out.println("a121_c = " + a121_c);
        // a121_c =                                                                    // Unicode символ с кодпоинтом \u0007
        System.out.println(Hex.encodeHexString("".getBytes(StandardCharsets.UTF_16)));
        // feff0007

        // 1 - способ
        a121_c = (char)('0' + a121);
        System.out.println("'0' + a121 = " + a121_c);
        // '0' + a121 = 7 , происходит сложение код поинта нуля и цифры 7 = '\u0030' + '\u0007' = '\u0030' + '\u0037'
        System.out.println(Hex.encodeHexString("7".getBytes(StandardCharsets.UTF_16)));
        // feff0037

        // 2 - способ
        System.out.println(Character.forDigit(a121 , 10));                          // 10 - основание системы счисления
        // 7
        int a123 = 71213;
        System.out.println(Integer.toString(a123));                                      // converts the given int to its String representation.
        // 71213
        System.out.println(Integer.toString(a123).charAt(0));
        // 7

        System.out.println("--- Преобразование char к int ---");
        // Преобразование char в int не сработает, поскольку это дает нам десятичное представление кодировки символа UTF-16

        char c123 = '7';
        System.out.println((int)c123 + ", hex = " + Integer.toHexString((int)c123));
        // 1 способ
        System.out.println("Character.getNumericValue = " + Character.getNumericValue(c123) + ", hex = " + Integer.toHexString(Character.getNumericValue(c123)));
        // 2 способ
        System.out.println("Integer.parseInt          = " + Integer.parseInt(String.valueOf(c123)) + ", hex = " + Integer.toHexString(Integer.parseInt(String.valueOf(c123))));
        // 3 способ
        c123 = '7' - '0';                                                                // Вычитание 0 работает
        System.out.println("7 - 0 : " + (int)c123 + ", hex = " + Integer.toHexString((int)c123));


        System.out.println("--- Кодирование символов (чисел) Unicode 1 ---");
        char a122 = 48;                                                                  // 0, 48 - это dec-код поинт 0-ля в таблице Unicode
        System.out.println("0 по dec-коду (48)     : " + a122);
        a122 = 0x0030;                                                                   // тот же код поинт в 16-ти hex виде
        System.out.println("0 по hex-коду (0x0030) : " + a122);
        System.out.println(Character.toChars(48));                              // печать нуля по код поинтам
        System.out.println(Character.toChars(0x0030));
        System.out.println(Character.toChars('\u0030'));

        System.out.println("--- Кодирование символов (чисел) Unicode 2 ---");
        System.out.println(Hex.encodeHexString("0".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Hex.encodeHexString("0".getBytes(StandardCharsets.UTF_16BE)));
        System.out.println(Hex.encodeHexString("0".getBytes(StandardCharsets.UTF_16LE)));
        System.out.println(Hex.encodeHexString("0".getBytes(StandardCharsets.UTF_16)));

        System.out.println("--- Кодирование смайлика ---");
        System.out.println(Character.toChars(0x1F600));
        //System.out.println(Character.toChars('\uD83D\uDE00'));        -- суррогатные пары toChars НЕ принимает
        System.out.println("\uD83D\uDE00");

        System.out.println("--- Получение любого символа Unicode по его код поинту и кодирование по любой выбранной схеме ---");
        System.out.println(Character.toChars(0x1234));
        System.out.println(Hex.encodeHexString("ሴ".getBytes(StandardCharsets.UTF_16BE)));
        System.out.println(Hex.encodeHexString((new String(Character.toChars(0x1234))).getBytes(StandardCharsets.UTF_16LE)));


        // Charset.forName("UTF-16BE").encode("0"))                                      -- результат ByteBuffer
        // ByteBuffer content = Charset.forName("UTF-16LE").encode("П");

        // ByteBuffer это как "удобная" альтернатива по работе с массивом байт
        // тем более некоторые операции как выше могут вернуть результать в этом типе
        // пока не до конца ясно где и с какими преимуществами его применять..
        // декларируют
        // ByteBuffer в Java упрощает работу с бинарными данными, предлагая удобные средства для чтения и записи примитивных типов,
        // размещённых в массиве байт. 1
        // Главное назначение ByteBuffer — повышение эффективности ввода/вывода благодаря непосредственному доступу
        // к данным на низком уровне.
        //
        // ByteBuffer применяется в разработке высокопроизводительных приложений и программ,
        // где критичны показатели задержки, например, при реализации TCP/IP-протокола на Java или обработке ввода/вывода
        // в базах данных.
        // Также он выступает мостом между нативным кодом С++ и Java, что оптимизирует передачу данных и приводит
        // к улучшению производительности графики.
        //
        // Классы Buffer являются основой, на которой построена Java NIO.
        // Однако в этих классах чаще всего используется класс ByteBuffer. Это связано с тем, что тип byte является
        // наиболее универсальным. Например, мы можем использовать байты для создания других non-boolean primitive types
        // в JVM и для передачи данных между JVM и внешними устройствами ввода-вывода.

        //ByteBuffer bb = ByteBuffer.allocate(4);
        //bb.order(ByteOrder.LITTLE_ENDIAN);
        //bb.putInt(16);                                 -- записать 16 в виде массива байт

        // Пример из Step02TypesBigInteger
        // Операцию по получению массива байт какого-то числа можно еще сделать через ByteBuffer
        // System.out.println("Разложим Long.MIN_VALUE в массив байт и сделаем из него BigInteger");
        // byte[] bimax_arr2 = ByteBuffer.allocate(Long.BYTES).putLong(Long.MIN_VALUE).array();
        // System.out.println("bimax_arr2 = " + Arrays.toString(bimax_arr2));
        // bimax_arr2 = [-128, 0, 0, 0, 0, 0, 0, 0]

        //byte[] anArray = { 0x10 };
        //byte[] b11 = {}; //new byte[bb.remaining()];   // как именно получать данные из ByteBuffer в byte[] надо изучать доку, там есть ньюансы
                                                         // для начала можно вообще начать со знакомства с ByteBuffer
                                                         // https://www.baeldung.com/java-bytebuffer
        //byte[] b12 = new byte[bb.remaining()];
        // If what you want is to retrieve the bytes that are remaining(!) (between position and limit),
        // then what you have will work.

        // System.out.println(Arrays.toString(anArray));

        // byte[] bom = { (byte) 0xff, (byte) 0xfe };
        // byte[] tmp = ArrayUtils.addAll(new byte[] {(byte) 0xFF, (byte) 0xFE}, "П".getBytes(StandardCharsets.UTF_8));
        // Arrays.toString(bom);


        //System.out.println(Hex.encodeHex(anArray));

    }
}
