package com.ams.train;

import java.util.HashSet;

public class Step18HashSet {

    public static void main(String[] args) {

        System.out.println("HashSet: инициализация с дубликатами");
        HashSet<Integer> hs11 = new HashSet<Integer>();
        hs11.add(1);
        hs11.add(2);
        hs11.add(3);
        hs11.add(4);
        hs11.add(5);
        hs11.add(5);    // никаких ошибок не будет, просто повторно значение не добавит
        System.out.println("HashSet<Integer> hs11 = " + hs11);


        System.out.println();
        System.out.println("HashSet: Операции с множествами");
        HashSet<Integer> hs12 = new HashSet<Integer>();
        hs12.add(1);
        hs12.add(2);
        hs12.add(3);
        hs12.add(4);
        hs12.add(5);

        HashSet<Integer> hs13 = new HashSet<Integer>();
        hs13.add(1);
        hs13.add(2);
        hs13.add(3);
        hs13.add(4);
        hs13.add(5);

        HashSet<Integer> hs2 = new HashSet<Integer>();
        hs2.add(4);
        hs2.add(5);
        hs2.add(666);
        hs2.add(777);
        hs2.add(888);

        System.out.println("Множество h11");
        System.out.println(hs11.toString());
        System.out.println("Множество h12");
        System.out.println(hs12.toString());
        System.out.println("Множество h13");
        System.out.println(hs13.toString());
        System.out.println("Множество hs2");
        System.out.println(hs2.toString());

        hs11.addAll(hs2);
        System.out.println("h11 UNION hs2       result : " + hs11.toString()); // 1, 2, 3, 4, 5, 6, 7, 8

        hs12.retainAll(hs2);
        System.out.println("hs12 INTERSECT hs2  result : " + hs12.toString()); // 4, 5

        hs13.removeAll(hs2);
        System.out.println("hs13 SUBTRACT hs2   result : " + hs13.toString());  // 1, 2, 3

      }
}
