package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by panyanming on 2019/11/11.
 */
@Component
public class MergeSortImpl implements ISortService {
    @Override
    public boolean verify(Integer condition) {
        return condition.intValue() == 1;
    }

    @Override
    public void sort() {
        System.out.println("归并排序,时间复杂度是O(nlogn)");
        int arr[] = new int[]{3, 8, 7, 9, 6, 10, 2, 5};

        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int q = (end + start) / 2;
            mergeSort(arr, start, q);
            mergeSort(arr, q + 1, end);
            merge(arr, start, q, end);
        }

    }

    private void merge(int[] arr, int start, int middle, int end) {
        //思路：建立两个数组，存储左边和右边，比较两个数组，从start位置替换arr的元素
        int leftSize = middle - start + 1;
        int[] left = new int[leftSize + 1];

        int rightSize = end - (middle + 1) + 1;
        int[] right = new int[rightSize + 1];

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = arr[middle + 1 + j];
        }
        left[leftSize] = Integer.MAX_VALUE;
        right[rightSize] = Integer.MAX_VALUE;

        int m = 0, n = 0;
        for (int k = start; k <= end; k++) {
            if (left[m] <= right[n]) {
                arr[k] = left[m];
                m++;
            } else {
                arr[k] = right[n];
                n++;
            }
        }
    }
}
