package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISPI;
import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/11/11.
 */
@Component
public class QuickSortImpl implements ISortService {

    @Override
    public boolean verify(Integer condition) {
        return condition == 2;
    }

    @Override
    public void sort() {
        System.out.println("快速排序,时间复杂度是O(nlogn)");
        int arr[] = new int[]{3, 8, 7, 9, 6, 10, 2, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }


    public void quickSort(int[] arr, int start, int end) {
        //思路： 找到一个pivot,一趟排序把数组分为两部分，左边部分比pivot小，右边部分比pivot大
        if (start < end) {
            int pivot = pivot(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int pivot(int[] arr, int start, int end) {
        int temp = arr[end];
        int i = start, j = end;
        while (i < j) {
            while (arr[i] <= temp && i < j) {
                i++;
            }
            while (arr[j] >= temp && i < j) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, end);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
