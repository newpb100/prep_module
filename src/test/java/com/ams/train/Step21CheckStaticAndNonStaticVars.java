package com.ams.train;

import com.ams.train.supply.StaticSumAndCounter;

public class Step21CheckStaticAndNonStaticVars {


    public static void main(String[] args) {

        (new StaticSumAndCounter()).add(1);
        //        public static int sum = 1
        //        public static int count = 1
        //        local sum = 2

        (new StaticSumAndCounter()).addStatic(1);
        //        public static int sum = 2
        //        public static int count = 2
        //        local sum = 2

        StaticSumAndCounter.addStatic(1);
        //        public static int sum = 3
        //        public static int count = 3
        //        local sum = 2

    }
}
