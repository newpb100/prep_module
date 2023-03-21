package com.ams.test.sandbox;

public class Step04KPR {

    double[] larr_5013_md = {0.8, 0.8, 0.6, 0.8, 0.49, 4.39};
    double[] parr_5013 = {191.2, 8.1, 23.0, 53.8, 3.6, 1059.0};

    double[] larr_10981_md = {0.67, 0.76, 0.58, 2.5, 0.96};
    double[] parr_10981 = {98.1, 13.6, 6.8, 1247.1, 30.9};


    Step04KPR(){
        //doKprCelevInt(larr_5013_md, parr_5013);
        doKprCelevInt(larr_10981_md, parr_10981);

    }

    private void doKprCelevInt(double[] arr1, double[] arr2){
        double proiz=0.0;
        double sumproiz=0.0;
        double sum=0.0;

        for (int i=0; i < arr1.length; i++){
            proiz = arr1[i] * arr2[i];
            //System.out.println(proiz);
            sumproiz = sumproiz + proiz;
            sum = sum + arr1[i];
        }
        System.out.println(sumproiz);
        System.out.println(sum);
        System.out.println("result = " + sumproiz/sum);
    }

}
