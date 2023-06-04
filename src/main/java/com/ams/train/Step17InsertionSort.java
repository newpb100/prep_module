package com.ams.train;

import java.util.Arrays;

public class Step17InsertionSort {

    public static void main(String[] args) {
        //int[] arr = {-120, -1000, 87, 0, 11, 26, 87, 4, -1500};
        //int[] arr = {10, 2, 10, 3, 1, 2, 5};
        //int[] arr = {39, -1000, 39, -12000, 10000, 12, 11, 11, 1};
        int[] arr = {39};
        int value = 0;
        int i = 0;

        System.out.println(Arrays.toString(arr));

        // 1. двигаем направа левую границу
        for (int left = 0; left < arr.length; left++) {

            value = arr[left];
            i = left - 1;
            for (; i >= 0 ; i--) {
                if (value < arr[i]){
                    arr[i + 1] = arr[i];        // 2. если есть что-то больше взятой границы перекопируем его направо и идем дальше
                                                //    опять кто-то больше снова перкопируем направо
                }else{
                    break;                      // 3. как только нашли кто меньше вылетаем
                }
            }
            arr[i + 1] = value;                 // 4. если нашли кого-то меньше, то вставку той самой левой границы производим перед ним,
                                                //   если цикл дошел до 0, то за пределами цикла i будет равно -1
                                                //   то есть текущую левую границу скинем в arr[0]
        }

        System.out.println(Arrays.toString(arr));
    }
}
