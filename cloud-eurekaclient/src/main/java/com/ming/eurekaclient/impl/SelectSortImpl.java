package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/11/12.
 */
@Component
public class SelectSortImpl implements ISortService {
    @Override
    public boolean verify(Integer condition) {
        return condition == 4;
    }

    @Override
    public void sort() {
        System.out.println("快速排序,时间复杂度是O(nlogn)");
        int arr[] = new int[]{3, 8, 7, 9, 6, 10, 2, 5};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void selectionSort(int[] arr) {
        int n = arr.length - 1;
        while (n > 0) {
            int maxIndex = getMaxIndex(arr, n);
            swap(arr, maxIndex, n);
            n--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int getMaxIndex(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

}
