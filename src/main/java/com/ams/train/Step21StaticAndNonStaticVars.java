package com.ams.train;

public class Step21StaticAndNonStaticVars {

    public static int count = 0;
    public static int sum = 0;

    public void add(int data)
    {
        int sum = data * 2;
        Step21StaticAndNonStaticVars.sum = Step21StaticAndNonStaticVars.sum + data;
        count++;

        printVars(sum);
    }

    public static void addStatic(int data)
    {
        int sum = data * 2;
        Step21StaticAndNonStaticVars.sum = Step21StaticAndNonStaticVars.sum + data;

        count++;
        printVars(sum);
    }

    private static void printVars(int sum) {
        System.out.println();
        System.out.println("public static int sum = " + Step21StaticAndNonStaticVars.sum);
        System.out.println("public static int count = " + Step21StaticAndNonStaticVars.count);
        System.out.println("local sum = " + sum);
    }

}
