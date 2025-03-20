package com.ams.train.supply;

public class StaticSumAndCounter {

    public static int count = 0;
    public static int sum = 0;

    public void add(int data)
    {
        int sum = data * 2;
        StaticSumAndCounter.sum = StaticSumAndCounter.sum + data;
        count++;

        printVars(sum);
    }

    public static void addStatic(int data)
    {
        int sum = data * 2;
        StaticSumAndCounter.sum = StaticSumAndCounter.sum + data;

        count++;
        printVars(sum);
    }

    private static void printVars(int sum) {
        System.out.println();
        System.out.println("public static int sum = " + StaticSumAndCounter.sum);
        System.out.println("public static int count = " + StaticSumAndCounter.count);
        System.out.println("local sum = " + sum);
    }

}
