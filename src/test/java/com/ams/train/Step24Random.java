package com.ams.train;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Step24Random {

    public static int a = 41;
    public static int c = 11119;
    public static int m = 11113;
    public static int seed = 1;

    public static void main(String[] args) {

        /// Math.random
        /// При первом вызове этого метода создается один новый генератор псевдослучайных чисел, как если бы он был создан с помощью выражения
        /// new java.util.Random()
        ///
        System.out.println("Math.random: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(Math.random() + " ; ");          // 0.2580076591594421 ; 0.9464908093622099 ; 0.4704744284447343 ...
        }

        /// Random
        var rand = new Random();
        byte[] btarr = new byte[10];

        System.out.println();
        System.out.println("Using Random()");
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextInt(10));           // with bound-not inclusive, т.е. до 10
        System.out.println(rand.nextInt());
        System.out.println("генерация случайного целого через BigInteger");
        System.out.println("BigInteger.probablePrime(8,rand) = " + BigInteger.probablePrime(8, rand));

        ///
        System.out.println();
        System.out.println("Рандом для случайного бросания кубика");
        System.out.println(rand.nextInt(6) + 1);

        ///
        System.out.println();
        System.out.println("Генерация Random().nextInt()");
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt());
        System.out.println("Генерация стрима из 5 случайных чисел в границах 1 и 6 включительно с помощью Random().ints");
        new Random().ints(5, 1, 7).forEach(n -> System.out.println(n));
        System.out.println();
        System.out.println("Генерация стрима из 5 случайных чисел в границах 1 и -6 включительно с помощью Random().ints");
        //new Random().ints(5, 1, -7).forEach(n -> System.out.println(n));                                                      // Err: IllegalArgumentException

        System.out.println();
        rand.nextBytes(btarr);                                 // заполнение псевдо-случайными числами массива
        System.out.println(Arrays.toString(btarr));

        System.out.println("nextGaussian 3 values:");
        System.out.println(rand.nextGaussian());
        System.out.println(rand.nextGaussian());
        System.out.println(rand.nextGaussian());

        ///
        System.out.println();
        System.out.println("Рандом генерит одинаковые псевдо-случайные числа, если передан одинаковый seed");
        Random rnd1 = new Random(1L);
        Random rnd2 = new Random(1L);
        boolean test = (rnd1.nextInt(16) == rnd2.nextInt(16));
        System.out.println("Test: " + test);


        ///  Custom method
        generateRandomSequenceCustom();


        /// SecureRandom
        System.out.println();
        System.out.println();
        SecureRandom secureRandom = new SecureRandom();
        System.out.println("Алгоритм по умолчанию: " + secureRandom.getAlgorithm());
        System.out.println("Провайдер: " + secureRandom.getProvider());
        System.out.println(Security.getAlgorithms("SecureRandom"));


        // Вывести случайное значение в диапазое min..max
        //genRandomValueInRangeTest();
        System.out.println();
        System.out.println("Генерация случайного значения в диапазоне " + 3 + ".." + 8);
        for (int i = 0; i < 10; i++) {
            System.out.println(genRandomValueInRange(3, 8));
        }

        // используем метод для генерации случайного числа для подсчета какое число сколько раз генерилось
        // рузельтат сложим в мапу, которая должна будет хранить результат в отсортированном виде
        // для этого подходит TreeMap
        System.out.println();
        System.out.println("Генерация случайного числа в диапазоне и подсчет статистики");
        genRandomValueInRangeStatistic(3, 8, 1000);
        System.out.println();
        System.out.println("Генерация случайного числа в диапазоне и подсчет статистики");
        genRandomValueInRangeStatistic(-3, 10, 1000);


        ///
        System.out.println();
        System.out.println("Генерация случайной строки на основе строки-алфавита ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        System.out.println(generateRandomString(10));
        System.out.println(generateRandomString(15));

        ///
        System.out.println();
        System.out.println("Генерация случайной строки на основе stream API и collect");
        System.out.println(genRandomStringWithStreamAPI());

        System.out.println("Генерация случайной строки (в данном случае только цифры) на основе stream API и forEach");
        StringBuilder sb = new StringBuilder();
        (new Random()).ints(10,48,58).forEach(i -> sb.appendCodePoint(i));
        System.out.println(sb.toString());

    }


    private static void generateRandomSequenceCustom() {
        System.out.println();
        for (int i = 0; i < 10; i++) {
            seed = (a * seed + c) % m;
            System.out.print(seed + " ; ");
        }
    }

    static void genRandomValueInRangeTest() {
        System.out.println();
        System.out.println();
        System.out.println("Вывести случайное значение в диапазоне 3..8 включительно");
        int min = 3;
        int max = 8;
        // узнаем наш диапазон, от 3 до 8 разница 5 значений, но если говорим о ВКЛЮЧИТЕЛЬНО, то в диапазон входит 6 значений! : 3, 4, 5, 6, 7, 8
        int range = max - min + 1; // = 6
        // если выполнять
        System.out.println((int) (Math.random() * range));
        // проверим на границах диапазона как будут генерироваться числа
        // они будут попадать в интервал (0..6) не включая границы
        System.out.println((int) (0.1 * range));  //0.6 к инту 0
        System.out.println((int) (0.99 * range));  //5.95 к инту 5
        // теперь просто добавим сюда сдвиг в наш требуемый интервал [3..8]
        System.out.println();
        System.out.println((int) (0.1 * range) + min);  //0.6 к инту = 0, потом + 3 = 3
        System.out.println((int) (0.99 * range) + min);  //5.95 к инту = 5, потом + 3  = 8
        // т.е. все значения должны генерится в интервале [3..8] проверим на выборке, там должны быть и 3 и 8!
        System.out.println();
        System.out.println("Проверка генерации рандомных значений в дапазоне 3 и 8 включительно");
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
        System.out.println((int) (Math.random() * range) + min);
    }

    static int genRandomValueInRange(int min, int max) {
        //System.out.println("Генерация случайного значения в диапазоне " + min + ".." + max);
        int range = max - min + 1; // = 6
        return ((int) (Math.random() * range) + min);
    }

    private static void genRandomValueInRangeStatistic(int min, int max, int howManyIterations) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int i = 0; i < howManyIterations; i++) {
            Integer randVal = genRandomValueInRange(min, max);

            if (!tm.containsKey(randVal)) {
                tm.put(randVal, 1);
            } else {
                tm.put(randVal, tm.get(randVal) + 1);
            }
        }

        System.out.println("Результат работы");
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            System.out.println(String.format("%d = [%d]", entry.getKey(), entry.getValue()));
        }
    }

    public static String generateRandomString(int length) {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            sb.append(characterSet.charAt(index));
        }
        return sb.toString();
    }

    public static String genRandomStringWithStreamAPI() {
        int leftLimit = 48; 			// numeral '0'
        int rightLimit = 122; 			// letter  'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)							// +1 т.к правая граница НЕ входит диапазон генерации
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,  StringBuilder::append)
                .toString();

        return generatedString;
    }
}
