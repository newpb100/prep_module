package com.ams.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Step18CollectionsList {

    public static void main(String[] args) {

        // Простой пример создания списка и наполнения его
        System.out.println("Простой пример создания списка и наполнения его с помощью add()");
        List<Object> stringList = new ArrayList<Object>();
        stringList.add("India");
        stringList.add("UAE");
        stringList.add("London");
        System.out.println(stringList);


        // Пример инициализации ФИКСИРОВАННОГО списка на основе массива (недоступны операции add/remove)
        System.out.println();
        System.out.println("Пример инициализации списка на основе массива (потом нельзя использовать add())");
        String[] fruits = {"apple", "banana", "orange"};

        List<String> fruitList = Arrays.asList(fruits);
        System.out.println(fruitList);
        // [apple, banana, orange]

        fruits[0] = "pineapple";        // можно изменить исходный массив и изменение отразится в списке
        System.out.println(fruitList);
        // [pineapple, banana, orange]

        // fruitList.add("grape");         // err! Exception in thread "main" java.lang.UnsupportedOperationException..
        // fruitList.remove(1);            // err! Exception in thread "main" java.lang.UnsupportedOperationException..

        // Пример с целыми
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(list);

        // Пример с фиксированным 2мерным массивом
        Object[][] myObj = new Object [][] {
                {1, 2, 3, 5},
                {1},
                {"ssstttrrr", true}
        };
        List<Object[]> cmyObjAsList = Arrays.asList(myObj); // инициализация списка из 2-мерного массива
        Object[] aa = cmyObjAsList.get(1);
        System.out.println(Arrays.toString(aa));
        // cmyObjAsList.add(new Object[]{0,0});             // err! Exception in thread "main" java.lang.UnsupportedOperationException


        // Пример инициализации списка с помощью Stream.of()
        System.out.println();
        System.out.println("Пример инициализации списка с помощью Stream.of()");
        List<String> myList = Stream.of("Apple", "Banana", "Cherry", "Date").collect(Collectors.toList());
        System.out.println(myList);

        myList.add("Strawberry");           // В данном случае методы add/remove отрабатывают
        myList.remove(2);
        System.out.println(myList);

    }
}
