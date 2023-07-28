package com.ams.train;

public class Step23Math {


    public static void main(String[] args) {

        ExploreLogOperations();
        MinAndMax();

    }

    private static void ExploreLogOperations() {
        // Math.log - натуральный логарифм
        System.out.println("2.71 ^ 1.3862943611198906 = " + (Math.pow(2.7118281828,1.386294361119890))); //3.9868408817748175


        System.out.println(Math.log(4));    // 1.3862943611198906

        System.out.println(Math.log1p(4));  // 1.6094379124341003 , к 4 добавляет еще 1
        System.out.println(Math.log(5));    // 1.6094379124341003, по сути, это натуральный логарифм 5

        //double a = 4.321E-10;
        System.out.println();
        double a = 4.4071449732959205059794028288502e-7;
        System.out.println(Math.log(a));    // -14.63486856949796 = ln(4.4071449732959205059794028288502e-7)
        System.out.println(Math.log1p(a));  // 4.407144002149865E-7

        System.out.println();
        System.out.println(Math.log(1.0 + a));   // 4.407144002260163E-7
        System.out.println(Math.log(1.0));       // 0
        System.out.println(Math.log1p(a));       // 4.407144002149865E-7
        System.out.println(Math.log1p(1.0));     // 0.6931471805599453

        System.out.println();
        double x = 0.000001;
        System.out.println(Math.log1p(x));       //9.999995000003334E-7
        System.out.println(Math.log(x));         //-13.815510557964274
        System.out.println(Math.log(0));
    }

    private static void MinAndMax() {

        int a = 4;
        int b = 3;
        int c = 2;
        int d = 1;

        System.out.println();
        System.out.println("min value = " + Math.min(a, Math.min(b, Math.min(c, d))));
        System.out.println("min value = " + Math.min(Math.min(a, b), Math.min(c, d)));
    }
}
