package com.ams.train;

import java.util.ArrayList;
import java.util.HashSet;

public class Step18HashSetAndArrayList {
    public static void main(String[] args) {
        // #1
        HashSet<Integer> hs11 = new HashSet<Integer>();
        hs11.add(1);
        hs11.add(2);
        hs11.add(3);
        hs11.add(4);
        hs11.add(5);
        hs11.add(5);

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
        hs2.add(6);
        hs2.add(7);
        hs2.add(8);

        System.out.println(hs11.toString());

        hs11.addAll(hs2);
        System.out.println("UNION     result : " + hs11.toString()); // 1, 2, 3, 4, 5, 6, 7, 8
        hs12.retainAll(hs2);
        System.out.println("INTERSECT result : " + hs12.toString()); // 4, 5
        hs13.removeAll(hs2);
        System.out.println("SUBTRACT  result : " + hs13.toString());  // 1, 2, 3

        // #2
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        System.out.println(al.toString());
        System.out.println("al.get(2) = " + al.get(2));

        al.remove(2);

        System.out.println(al.toString());
        System.out.println("al.get(2) = " + al.get(2));

      }
}
