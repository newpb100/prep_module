package com.ams.train;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Step19CompareCollections {
    public static void main(String[] args) {

        // 1. ArrayList

        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(1);
        al1.add(2);
        al1.add(3);

        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(3);
        al2.add(2);
        al2.add(1);

        // 1.1. Compare with     Assert.assertEquals
        //
        //Assert.assertEquals(al1, al2);
        //  Exception in thread "main" java.lang.AssertionError: expected:<[1, 2, 3]> but was:<[3, 2, 1]>


        // 1.2. Compare with     CollectionUtils
        //
        System.out.println(CollectionUtils.isEqualCollection(al1, al2));
        // true

        //ArrayList<Integer> al3 = new ArrayList<Integer>(Arrays.asList(3, 2, 1));
        //System.out.println(CollectionUtils.isEqualCollection(al1, al3));
        //true

        ArrayList<Integer> al3 = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4));
        System.out.println(CollectionUtils.isEqualCollection(al1, al3));
        // false


        // 1.3. smart method
        //listA.containsAll(listB) && listB.containsAll(listA)



        // 2. HashSet
        //HashSet




    }
}
