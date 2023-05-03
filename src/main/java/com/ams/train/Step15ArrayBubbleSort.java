package com.ams.train;

import java.util.Arrays;

public class Step15ArrayBubbleSort {

    public static void main(String[] args) {

        int[] arr = {-120, -1000, 87, 0, 11, 26, 87, 4, 100};

        boolean swap;
        int size = arr.length - 1;
        int tmp = 0;

        for (int j = size; j > 1; j--) {
            swap = false;

            for (int i = 0; i < j; i++) {

                if (arr[i] > arr[i+1]) {
                    tmp = arr[i + 1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;

                    swap = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swap)
                  break;
        }


    }
}
