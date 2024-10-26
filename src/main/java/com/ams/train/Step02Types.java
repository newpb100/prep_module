package com.ams.train;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

import static org.apache.commons.io.ByteOrderMark.UTF_16LE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step02Types {

    public static void doStep02Types(){

        /* primitive rules */
        // CHAR
        // экарнирование
        // escape последовательности
        // % операция
        //CASTs
        // расширение типов
        // сужение типов
        // char и short
        // Неявное преобразование к INT
        // int to str
        // operations from left to right
        // operations from right to left for =
        // increment/decrement , postfix and prefix
        // combine += /=
        // logic , has lower priority as compare ops
        // доп: интересные операции

        /* primitive rules */
        //
        float fl = 1.457f;
        long lg = -9223372036854L;
        Long boxl1 = Long.valueOf(lg);
        Long boxl2 = lg;   // неявно вызывается valueOf
        System.out.println("boxl1 = " + boxl1 + "; boxl2 = " + boxl2);

        Long box3 = 1234567L;
        long lg3 = box3.longValue();
        long lg4 = box3;  // неявно вызывается longValue
        System.out.println("lg3 = " + lg3 + "; lg4 = " + lg4);

        // вывод на консоль литералов с плавающей точкой, классический и научный
        double a12 = 2.718281828459045;
        double d12 = 4.05E-13;
        System.out.println();
        System.out.println("Тип double в классическом виде: " + a12);
        System.out.println("Тип double в научном виде: " + d12);


        // CHAR
        char symb1 = 1078;      //по индексу символа (его код в 10-м выражении) в таблице Unicode
        char symb2 = 'ж';       //по значению
        char symb3 = '\u0436';  //через шестнадцатеричную форму Unicode (это всё ещё «ж»), для 1078 в 16-ричной системе это 0436
        // 1 line
        char symb4 = 1079, symb5 = 'з';
        char symb6 = (char) 1079;

        System.out.println("symb1       = " + symb1);  // ж
        System.out.println("symb2       = " + symb2);  // ж
        System.out.println("symb3       = " + symb3);  // ж
        System.out.println("symb4       = " + symb4);  // з
        System.out.println("++symb3     = " + (++symb3)); // так как char - это и целочисленный тип в том числе, то можно так писать  // з

        System.out.println("(char) 1079 = " + symb6);  // з

        // экранирование
        char a_doublq = '\"';
        char b_doublq = '"';

        System.out.println(" a_doublq = " + a_doublq); // будет выведена 1 двойная кавычка
        System.out.println(" b_doublq = " + b_doublq); // будет выведена 1 двойная кавычка

        // escape последовательности
        System.out.println();
        System.out.println("escape последовательности");
        System.out.println("\t\t100\t\t200\t\t300");
        System.out.println("\t\t10\t\t22\t\t33");
        System.out.println("\t\t1000\t\t2200\t\t3300");
        System.out.println("Добро пожаловать в \nв систему уважаемый анон");
        System.out.println("Добро пожаловать в систему уважаемый \b\b\b\b\b\b\b\b\bанон");  // Добро пожаловать в систему уанон
        System.out.println("Добро пожаловать в систему \rуважаемый анон");                  // уважаемый анон
        System.out.println("Рекомендуется к прочтению 'Углубленный курс JAVA', \\youtube\\ ");
        // комбинированная кодировка
        System.out.println("\uD83D\uDD0A");
        System.out.println("\uD83E\uDD73");
        System.out.println("\uD83C\uDF81");
        System.out.println("Улыбок тебе дед Макар \u263A \u263B");
        // некоторые символы просто так не интерпертируются в строке, например 0x1F600, если написать \u1F600 ничего не получится
        // но если так, то ОК
        // источник:         https://javarush.com/groups/posts/literaly-v-java
        int smile = 0x1F600; // Здесь шестнадцатеричный код эмоджи
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toChars(smile)); // Собираем в StringBuilder
        System.out.println("Улыбающееся лицо: " + sb.toString()); // Выводим
        //
        // из комментов , то же самое без StringBuilder , действительно на фиг его городить тут
        String asmile = new String(Character.toChars(0x1F600));
        System.out.println("Улыбающееся лицо через String: " + asmile);

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
        // printf() выводит отформатированную строку в консоль. Для этого на входе должна быть строка формата, которая указывает, что печатать,
        // и один или несколько последующих аргументов. В строке формата могут быть спецификаторы преобразования (местоholders, начинающиеся с%),
        // которые указывают, как форматировать последующие аргументы функции.
        // String.format() возвращает отформатированную строку, которую можно сохранить или использовать по своему усмотрению.

        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_8))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16BE))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16LE))));
        System.out.println(String.format("0x%010x", new BigInteger(1, "П".getBytes(StandardCharsets.UTF_16))));

        System.out.println("для П через Hex.encodeHexString");
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
        // - неважно десятично/не десятичное, сначала надо получить строковое представление числа, например "16" или hex представление "10"
        // - а потом закодировать каждый символ, используя таблицу Unicode, и одну из схем кодирования
        System.out.println("--- Получить hex представление целого в виде строки ---");
        System.out.println(Integer.toHexString(16));
        System.out.println(Integer.toHexString(160));


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
        System.out.println(a122);
        a122 = 0x0030;                                                                   // тот же код поинт в 16-ти hex виде
        System.out.println(a122);
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

        //ByteBuffer content = Charset.forName("UTF-16LE").encode("П");
        //byte[] bom = { (byte) 0xff, (byte) 0xfe };
        ///byte[] tmp = ArrayUtils.addAll(new byte[] {(byte) 0xFF, (byte) 0xFE}, "П".getBytes(StandardCharsets.UTF_8));
        // Arrays.toString(bom);

        //ByteBuffer bb = ByteBuffer.allocate(4);
        //bb.order(ByteOrder.LITTLE_ENDIAN);
        //byte[] anArray = { 0x10 };
        //bb.order(ByteOrder.BIG_ENDIAN);
        //bb.putInt(16);
        //byte[] b11 = {}; //new byte[bb.remaining()];
        //byte[] b12 = new byte[bb.remaining()];
        // System.out.println(Arrays.toString(anArray));

        //System.out.println(Hex.encodeHex(anArray));


        // before print it, init it
        Sample ts = new Sample("test string",1);
        String str;
        System.out.println("print object = " + ts);      // ok
        //System.out.println("print object = " + str);   // err


        // CASTS
        // расширение типов
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        float f = lmax;
        System.out.println("");
        System.out.println("Long.MAX_VALUE     = " + Long.MAX_VALUE);    //Long.MAX_VALUE     = 9223372036854775807
        System.out.println("float f = lmax ; f = " + lmax);              //float f = lmax ; f = 9223372036854775807
        f = lmin;
        System.out.println("Long.MIN_VALUE     = " + Long.MIN_VALUE);    //Long.MIN_VALUE     = -9223372036854775808
        System.out.println("float f = lmin ; f = " + lmin);              //float f = lmin ; f = -9223372036854775808

        int intA = Integer.MAX_VALUE;
        System.out.println();
        System.out.println("int intA;                         intA  = " + intA);       //2147483647
        System.out.println("int intA + 1 ;                  intA+1  = " + (intA + 1)); //-2147483648
        long longRes = intA + 1;
        System.out.println("long longRes = intA + 1;       longRes  = " + longRes);    //-2147483648  !!!
        long longRes1 = (long)intA + 1;
        System.out.println("long longRes = (long)intA + 1; longRes1 = " + longRes1);   //2147483648



        // сужение типов
        //#1
        long lmil = 1000000L;               //
        int lMilInt = (int)lmil;            // 00000000 00001111 01000010 01000000 = 1 000 000 dec
        short lMilShort = (short )lMilInt;  //                   01000010 01000000 = 16980 dec
        byte lMilByte = (byte) lMilInt;     //                            01000000 = 64 dec

        System.out.println();
        System.out.println("short lMilShort = (short )lMilInt ; lMilShort = " + lMilShort);
        System.out.println("byte lMilByte = (byte) lMilInt    ; lMilByte  = " + lMilByte);

        //#2
        byte b128 = (byte)128;
        System.out.println();
        System.out.println("byte b128 = (byte)128;                   b128 = " + b128);
        // результат -128
        // Обоснование
        // 128 - 127 (максимальное в диапазоне) = 1; - это остаток, который нужно "проматывать" с другого конца
        // идем с другого конца
        // -128 + 1 - 1 = -128  , -1 делаем, потому что за 127 сразу идет -128, которое надо учитывать

        //#3
        long l123 = 1298390390L;               //01001101 01100011 11011101 01110110 = 1298390390 dec
        short sh123 = (short) l123;            //                  11011101 01110110 = 56694 dec ; 56694 - 32767 = 23927; -32768 + 23927 -1 = -8842
        //                                                  -1 потому что

        System.out.println("short sh123 = (short) 1298390390L;      sh123 = " + sh123);

        // char и short
        // несмотря на то, что они оба по 2 байта, преобразование обязательно, так как char-беззнаковый
        short shr = 75;
        char sym = (char) shr;
        System.out.println();
        System.out.println("char sym = (char) shr;   sym = " + sym);

        char sym2 = (char)-1;
        System.out.println("char sym2 = (char)-1; sym2           = " + sym2);
        System.out.println("char sym2 = (char)-1; (short)sym2    = " + (short)sym2);
        System.out.println("((short)65535)                       = " + ((short)65535)); //-1        диапазон:-32768    32767
        System.out.println("((short)32768)                       = " + ((short)32768)); //-32768    диапазон:-32768    32767
        System.out.println("char sym2 = (char)-1; (int)sym2      = " + (int)sym2);      //65535     диапазон:0         65535

        // Неявное преобразование к INT
        byte a = 120;
        byte b = 120;
        // byte c = a + b;              // err! result is INT
        int c = a + b;
        byte c1 = (byte)(a + b);        // операция возможна только с явным кастом

        //byte c2 = a + 1;              // err! result is INT, потому что 1 - это беззнаковый литерал типа INT
        byte c2 = (byte)(a + 1);
        //byte c2 = (byte)a + 1;        // Внимание! каст более приоритетный чем арифметическая операция

        byte c3 = 1 + 1;                // загадка! как так?  !!!!!!!!!!!!!!!
        System.out.println();
        System.out.println("byte c3 = 1 + 1; c3 = " + c3);

        short d = 100;
        // short e = d + a;             // err! result is INT
        int e = d + a;
        short e1 = (short)(d + a);      // операция возможна только с явным кастом


        // int to str
        //String str15 = 15; //err
        String str15 = "" + 15;

        // str to int
        int a1 = Integer.parseInt(str15);
        System.out.println();
        System.out.println("print a1 = " + a1);

        // operations from left to right
        int a2 = 5;
        String str5 = a2 + a2 + "" + a2;
        System.out.println("print str5 = " + str5);   // 105 !

        // operations from right to left for =
        a2 = 5;
        int a3 = 6;
        int a4 = 7;
        int a5 = a2 = a3 = a4;
        System.out.println("a5 = " + a5 + " a4 = " + a4 +" a3 = " + a3 +" a2 = " + a2);   // 7 7 7 7

        // increment/decrement , postfix and prefix
        int a6 = 10;
        int y = a6++;
        System.out.println("postfix y = " + y + " ; a6  = " + a6);  // 10 11
        y = ++a6;
        System.out.println("prefix y = " + y + " ; a6  = " + a6);   // 12 12
        int aaa = 5;
        int bbb = ++aaa + ++aaa;
        System.out.println("bbb = ++aaa + ++aaa; bbb =  " + bbb); //13

        // combine
        y += a6;
        System.out.println("combine add y = " + y);      // 12 + 12 = 24
        y /= a6;
        System.out.println("combine division y = " + y); // 24 / 12 = 2

        // logic , has lower priority as compare ops
        System.out.println(" && : " + ( 100 > 2 && 100 < 100 )); // false
        System.out.println(" || : " + ( 100 > 2 || 100 < 100 )); // true

        // доп: интересные операции
        boolean ad = true;
        int addd = 2;
        System.out.println("! ad      = " + !ad);            // false
        System.out.println("~ addd    = " + ~addd);          // 1111 1101 , в десятичной = -3, т.к. это простая инверсия числа
        System.out.println(">>>= addd = " + (addd >>>= 1));  // 1

        // BigDecimal
        System.out.println();
        System.out.println("BigDecimal");

        BigDecimal bdthirdValue = new BigDecimal(3445.125, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.125
        bdthirdValue = new BigDecimal(3445.1255, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.126
        bdthirdValue = new BigDecimal(3445.1265, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.126
        bdthirdValue = new BigDecimal(3445.1275, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.128

        System.out.println();
        bdthirdValue = new BigDecimal(3445.1455, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.146
        bdthirdValue = new BigDecimal(3445.1465, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.146

        System.out.println();
        System.out.println("------------ LL --------------------------------");
        bdthirdValue = new BigDecimal(3445.5545, MathContext.DECIMAL32);
        System.out.println(new BigDecimal(3445.5545));
        System.out.println(bdthirdValue);
        // 3445.555   ???????
        DecimalFormat decimalFormat = new DecimalFormat("####.###");
        String result = decimalFormat.format(3445.5545);
        System.out.println((result));
        // 3445,555
        bdthirdValue = new BigDecimal(3445.5445, MathContext.DECIMAL32);
        System.out.println(new BigDecimal(3445.5445));
        System.out.println(bdthirdValue);
        // 3445.544
        decimalFormat = new DecimalFormat("####.###");
        result = decimalFormat.format(3445.5445);
        System.out.println((result));
        // 3445,544
        System.out.println("------------ LLEND--------------------------------");

        System.out.println();
        bdthirdValue = new BigDecimal("2222.2225");
        System.out.println(bdthirdValue.setScale( 3,  RoundingMode.HALF_EVEN )) ;
        // 2222.222
        bdthirdValue = new BigDecimal("2222.22255");
        System.out.println(bdthirdValue.setScale( 3,  RoundingMode.HALF_EVEN )) ;
        // 2222.223
        bdthirdValue = new BigDecimal("3445.5445");
        System.out.println(bdthirdValue.setScale( 3,  RoundingMode.HALF_EVEN )) ;
        // 3445.544


        // Внимание! Различие в округлении!
        System.out.println();
        bdthirdValue = new BigDecimal("3445.5545");
        System.out.println(bdthirdValue.setScale( 3,  RoundingMode.HALF_EVEN )) ;
        // 3445.554

        bdthirdValue = new BigDecimal(3445.5545);
        System.out.println(bdthirdValue);
        decimalFormat = new DecimalFormat("####.###");
        System.out.println(decimalFormat.format(bdthirdValue.setScale(3, RoundingMode.HALF_EVEN)));
        // 3445.554


        decimalFormat = new DecimalFormat("####.###");
        result = decimalFormat.format(3445.5545);
        System.out.println((result));
        // 3445,555
        double ddd1 = 3445.5545;
        decimalFormat = new DecimalFormat("####.###");
        result = decimalFormat.format(ddd1);
        System.out.println((result));
        // 3445,555

        bdthirdValue = new BigDecimal(3445.5545, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.555
        bdthirdValue = new BigDecimal(ddd1, MathContext.DECIMAL32);
        System.out.println(bdthirdValue);
        // 3445.555

        ddd1 = 3445.5545;
        decimalFormat = new DecimalFormat("####.###");
        // Если предыдущее число чётное, округление производится:
        result = decimalFormat.format(ddd1);
        System.out.println(result);
        // 3445,555 - верно
        ddd1 = 3445.5545;

    }

    public static void doNanAndInfinity() {
        //System.out.println(100/0);                // exception! by zero
        System.out.println(100.0/0.0);              //Infinity
        System.out.println(100f/0f);                //Infinity
        System.out.println(100d/0d);                //Infinity
        System.out.println((100d/0d + 1));          //Infinity
        System.out.println((100d/0d * 10));         //Infinity
        System.out.println(-100.0/0.0);             //-Infinity

        System.out.println(0.0/0.0);                //NaN
        System.out.println((0.0/0.0 + 10));         //NaN
        System.out.println((100d/0d + 0.0/0.0));    //Infinity + NaN = NaN
        double a  = 1.0/0.0;
        System.out.println("Infinity / Infinity = " + a/a);   // Infinity / Infinity = NaN

    }

    public static void doBooleanOperations() {

        String s = null;

        if (s != null && s.length() > 10){      // && - безопасная форма записи, так как выражение вычисляется ленивым методом
            System.out.println("s != null , second part of expr won't calcutate");
        }else{
            System.out.println("s = null, stop work");
        }

        //if (s != null & s.length() > 10){       // exception here
        //    System.out.println("s = null, stop work");
        //}
    }

    public static void doUnixPathToWindowsChars() {
        String path_in = "/var/user/programm/unit1/";

        char[] pathArr = path_in.toCharArray();

        for (int i = 0; i < pathArr.length; i++) {
            if (pathArr[i] == '/'){   // обрати внимание , что в случае с чарами сравнение идет не через equals , а в прямую
                pathArr[i] = '\\';
            }
        }

        String path_out = new String(pathArr);
        System.out.println();
        System.out.println("Преобразование unix пути " + path_in);
        System.out.println("в windows " + path_out);

    }

    public static void doUnixPathToWindowsSplitJoin() {
        String path_in = "/var/user/programm/unit1/";

        String[] pathArr = path_in.split("/");

        String path_out = String.join("\\", pathArr);
        /* \\var\\user\\programm\\unit1  -- теряется конечный бэкслеш
         *   и тут в комментах пришлось использовать экранирование бэкслеша потому что вылетает ошибка о_О
         *   java: illegal unicode escape
         *   а это происходит из-за комбинации символов <backslash>u  :))
         * */

        System.out.println();
        System.out.println("Разделение и сбор пути с помощью Split и Join : " + path_out);

    }

    public static void doUnixPathToWindowsReplace() {
        String path_in = "/var/user/programm/unit1/";

        String path_out = path_in.replace("/", "\\");

        System.out.println();
        System.out.println("Замена пути с помощью Replace : " + path_out);
    }

    public static void doStringOperations() {
        System.out.println();
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcde"));                                     // = 0
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcdf"));                                     // < 0
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcda"));                                     // > 0
        System.out.println("Проверка пути : " + "/usr/bin/logstash/logs/access.log".startsWith("/usr"));                        //true
        System.out.println("Проверка пути : " + "/usr/bin/logstash/logs/access.log".endsWith("/usr"));                          //false
        System.out.println("Ищем второе вхождение log: " + "/usr/bin/logstash/logs/access.log".indexOf("log",15)); //18 , индекс считает от 0, 18 это номер буквы l в log

        System.out.println("Использование substring : " + "Использование substring : ".substring(0,4));                         //Испо - Как и во всех интервалах в Java, символ с номером endIndex в интервал не входит.
        System.out.println("Repeat       : " + "repeat".repeat(3));
        System.out.println("replaceFirst : " + "repeat".replaceFirst("e","X"));                                 //rXpeat
        System.out.println("replaceAll   : " + "repeat".replaceAll("e","X"));                                   //rXpXat
        System.out.println("regex more difficult: " + "repeat here is text".replaceFirst("(e)(.+)","X"));       //rX

        System.out.println("Example of using StringTokenizer");
        String greating = "Good news everyone!";
        var tokenizer = new StringTokenizer(greating, "ne");  //разделителем считается каждый символ строки, переданный второй строкой в конструктор
        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
        //        Good
        //        ws
        //        v
        //        ryo
        //        !

        String s1 = String.format("Language = %s, MonthPeriod = %d, severity = %c", "java", 7, 'A');
        String s2 = String.format("Language = %2$s, MonthPeriod = %1$d, severity = %3$c", 1, "python", 'B');
        System.out.println("Course #1, details : " + s1);
        System.out.println("Course #2, details : " + s2);

        String aa = new String("Java lesson");
        String bb = new String("Java lesson");
        System.out.println("сравним ссылки aa и bb : " + (aa == bb));  // false

        String t1 = aa.intern();
        String t2 = bb.intern();
        System.out.println("сравним ссылки t1 и t2 : " + (t1 == t2));  // true


    }
}
