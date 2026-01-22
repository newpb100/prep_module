package com.ams.train;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step02TypesBigInteger {

    public static void doStep02TypesBigInteger() {
        //#4 (BigInteger)
        System.out.println("--- BigInteger to primitive int ---");
        BigInteger value = new BigInteger("19223372036854775807");
        //  long, с диапазоном от -9223372036854775808 до 9223372036854775807.

        long longValue = value.intValue();
        System.out.println("longValue      = " + longValue);
        // -1981284353

        // System.out.println("longValueExact = " + value.longValueExact());
        // проверка, что примитивный тип может быть извлечен, если не может , то будет эксепшн
        // Exception in thread "main" java.lang.ArithmeticException: BigInteger out of long range

        BigInteger firstValue = new BigInteger("-10");
        BigInteger secondValue = new BigInteger("4");
        BigInteger resultValue = firstValue.mod(secondValue);
        // 2
        // см. больше про mod и % в Step02TypesOstatok

        byte barr48[]={4,8};														// Конструктор по массиву байт
        BigInteger bi48 = new BigInteger(barr48);
        System.out.println("BigInteger по массиву байт {4,8} = " + bi48);
        // 00000100_00001000  (8 + 1024 = 1032)
        // 1032

        System.out.println();
        // в основе
        // https://www.baeldung.com/java-biginteger
        System.out.println("Выход за диапазон границы long");
        System.out.println("С помощью setBit()");
        BigInteger bimax = BigInteger.ZERO.setBit(63);                              // setBit сдвигает 1 на 63 бита влево, т.е. 1 в 64 позиции
        System.out.println("str_bimax = " + bimax.toString(2));
        // 10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000  // -2^63
        assertEquals(64, bimax.bitLength());

        System.out.println("str_bimax = " + bimax.toString(10));
        // 9223372036854775808
        // странно что тут оно положительное, первым же битом идет 1 ..
        assertEquals(1, bimax.signum());
        // то есть он при создании числа битовым сдвигом, указывает, что число БЕЗЗНАКОВОЕ, выставляя signum=1

        System.out.println("Проверки старт");
        assertEquals(BigInteger.ONE, bimax.subtract(BigInteger.valueOf(Long.MAX_VALUE)));
        assertEquals(64, (bimax.toString(2)).length());
        assertTrue((bimax.toString(2)).matches("^10{63}$"));              // 1000 0000 ... 0000
        System.out.println("Проверки стоп");


        // а можно сделать MIN_VALUE для Long так
        System.out.println("bimax_arr2 = {-128, 0, 0, 0, 0, 0, 0, 0};");
        byte[] bimax_arr = {-128, 0, 0, 0, 0, 0, 0, 0};
        // BigInteger bimax_signed = new BigInteger(1, bimax_arr);
        BigInteger bimax_signed = new BigInteger(bimax_arr);
        System.out.println("bimax_signed = " + bimax_signed.toString(2));
        // -10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000
        System.out.println("bimax_signed = " + bimax_signed);
        // -9223372036854775808

        assertEquals(-1, bimax_signed.signum());
        // получилось число ЗНАКОВОЕ, хотя представление в 2-м виде такое же как и в примере выше(!), хотя он и добавляет "-" спереди

        // но принудительно можно указать, что данное число является ПОЛОЖИТЕЛЬНЫМ
        System.out.println();
        System.out.println("Принудительный перевод в положительное число");
        BigInteger bimax_unsigned = new BigInteger(1, bimax_arr);
        System.out.println("bimax_unsigned = " + bimax_unsigned.toString(2));
        // 10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000
        System.out.println("bimax_unsigned = " + bimax_unsigned);
        // 9223372036854775808
        // кстати, если раскрыть в дебаггере значение переменной bimax_unsigned
        // то увидим
        // mag={int|2|@933}[-2147483648, 0]
        // 0 = -2147483648
        // 1 = 0
        // то есть 9223372036854775808 представлено в виде 2х 4х байтных integer, причем старщий равен -2147483648 (4 байта), младший 0 (4 байта)


        // Операцию по получению массива байт какого-то числа можно еще сделать через ByteBuffer
        System.out.println("Разложим Long.MIN_VALUE в массив байт и сделаем из него BigInteger");
        byte[] bimax_arr2 = ByteBuffer.allocate(Long.BYTES).putLong(Long.MIN_VALUE).array();
        System.out.println("bimax_arr2 = " + Arrays.toString(bimax_arr2));
        // bimax_arr2 = [-128, 0, 0, 0, 0, 0, 0, 0]

        // из -9223372036854775808 делаем 9223372036854775808 и проверяем с bimax=9223372036854775808
        assertEquals(bimax, new BigInteger(1, bimax_arr2));
        System.out.println("bimax (unsigned) = new BigInteger(1, bimax_arr2)<9223372036854775808>");


        // попробуй собрать long-максимальное положительное число и проверить, что у него bimax_long_max.signum()=1
        System.out.println();
        System.out.println("bimax_arr2 = {127, -1, -1, -1, -1, -1, -1, -1};");
        byte[] bimax_arr22 = {127, -1, -1, -1, -1, -1, -1, -1};
        BigInteger bimax_long_max = new BigInteger(bimax_arr22);
        System.out.println("bimax_long_max = " + String.format("0%s",bimax_long_max.toString(2))); // чтобы добавить в вывод ведущий 0
        // 01111111_11111111_11111111_11111111_11111111_11111111_11111111_11111111
        System.out.println("bimax_long_max = " + bimax_long_max);
        // 9223372036854775807

        //assertEquals(-1, bimax_long_max.signum());
        // Exception in thread "main" org.opentest4j.AssertionFailedError: expected: <-1> but was: <1>
        assertEquals(1, bimax_long_max.signum());


        // попробуй пособирать еще BigInteger и положительное и отрицательное из строки и проверить у них bimax_signed.signum()
        System.out.println();
        System.out.println("Проверка знака у BigInteger, собранных через строки");
        firstValue = new BigInteger("-34");
        assertEquals(-1, firstValue.signum());

        firstValue = new BigInteger("34");
        assertEquals(1, firstValue.signum());

    }
}
