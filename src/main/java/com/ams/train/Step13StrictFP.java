package com.ams.train;

public class Step13StrictFP {

    private strictfp double getSum(){
        double a = 1.1E18;
        double b = 444.55E18;

        return a + b;
    }


    public static void main(String[] args) {

        Step13StrictFP obj = new  Step13StrictFP();

        System.out.println("getSum as strictfp function : " + obj.getSum());
            //getSum as strictfp function : 4.4565E20
    }
}
