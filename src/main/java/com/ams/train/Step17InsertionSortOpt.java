package com.ams.train;

import edu.emory.mathcs.backport.java.util.Arrays;


// Напрашивается более понятное название сортировки "Со сдвигом влево наименьшего" ?
public class Step17InsertionSortOpt {

    public static void main(String[] args) {

        int[] arr = {-4, -100, 21, 0, -43, 120, -99, 65, 21};
        int[] arr1 = {-4, -100, 21};
        int j = 0;
        int buf = 0;

        for(int i=0 ; i < arr.length ; i++){

            buf = arr[i];
            j = i;

            while (j > 0 && arr[j-1] > buf){

                arr[j] = arr[j-1];
                j--;

            }
            arr[j] = buf;
        }

        System.out.println(Arrays.toString(arr));

        //assert isSorted(arr1) : "Массив отсортирован неправильно";
        assert isSorted(arr) : "Массив отсортирован неправильно";

    }

    private static boolean isSorted(int[] arr){
        for (int i = 0; i < (arr.length-1); i++) {
            if (arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }
}
