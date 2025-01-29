package com.ams.train;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Step30LambdasAndStreams {
    public static void doLambdasAndStreams() {

        // Примеры объявления стримов
        Stream<Integer> varStream = Stream.of(1, 2, 3, 4, 9);
        IntStream intStream = IntStream.of(120, 410, 85, 32, 314, 12);


        // Чтобы использовать внешние переменные в лямбда-выражениях они должны быть
        // final или effectivly final
        System.out.println();
        final int aa = 10;
        int cc = 1000;
        // c++;  //тогда в лямбда-выражение будет ошибка: var in lambda expr should be final or effectivly final

        Stream.of(1, 2).forEach(s-> System.out.println(s + aa));
        Stream.of(1, 2).forEach(s-> System.out.println(s + cc));
        //11
        //12
        //1001
        //1002

        // 11 + 2 + 3 + 4 + 5 = 25
        System.out.println();
        System.out.println("Проверка reduce()");
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(10, (acc, x) -> acc + x);

        System.out.println("Summa = " + sum);


        //
        System.out.println("");
        System.out.println("Проверка Collectors.joining()");
        String a = Stream.of("s", "u" ,"p", "e", "r").collect(Collectors.joining());
        System.out.println(a);

        String b = Stream.of("s", "u", "p", "e", "r").collect(Collectors.joining("-"));
        System.out.println(b);

        String c = Stream.of("s", "u", "p", "e", "r").collect(Collectors.joining(" -> ", "[ ", " ]"));
        System.out.println(c);


        // непонятный пример с JR
        System.out.println("");
        System.out.println("непонятный пример с JR");             // почему именно map + flatMap
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);

/*        streamOfArray.map(s->s.split("")) 				      // типа каждый элемент массива разбиваем на буквы..?
                .flatMap(Arrays::stream)                          // ???
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);*/

        System.out.println("==========");
        streamOfArray.map(s -> s.toUpperCase())
                     .forEach(System.out::println);
        // JAVA
        // RUUUUUSSSHHH


    }
}
