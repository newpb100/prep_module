package com.ams.train;

import java.util.Arrays;

public class Step16SelectionSort {
    int[] arr = {-120, -1000, 87, 0, 11, 26, 87, 4, -1500};
    //int[] arr = {39, -1000, 39, -12000, 10000, 12, 11, 11, 1};
    //int[] arr = {39};

    int minInd = 0;
    boolean isSwap = false;

    public void main() {

        /* внешним циклом походим только до предпоследнего элемента, до "4", а вот внутренний всегда идет до конца
           внутренний можно сразу стартовать с left+1, иначе первое сравнение элемента себя с самим, просто не нужно
        */
        for (int left = 0; left < arr.length-1; left++) {
            System.out.println("start compare elem index " + left + ": " + Arrays.toString(arr));
            isSwap = false;
            minInd = left;
            for (int i = left+1; i < arr.length; i++) {
                if (arr[i] < arr[minInd]) {
                    minInd = i;
                    isSwap = true;
                }
            }
            if (isSwap == true) {
                doSwap(arr, minInd, left);
            }
        }
        System.out.println("result array: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void doSwap(int[] arr, int minInd, int left) {
        int tmp = 0;
        tmp = arr[left];
        arr[left] = arr[minInd];
        arr[minInd] = tmp;
    }
}
