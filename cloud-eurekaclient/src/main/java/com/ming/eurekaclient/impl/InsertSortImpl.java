package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/11/12.
 */
@Component
public class InsertSortImpl implements ISortService {
    @Override
    public boolean verify(Integer condition) {
        return condition == 3;
    }

    @Override
    public void sort() {
        System.out.println("插入排序,时间复杂度是O(n^2)");
        int arr[] = new int[]{3, 8, 7, 9, 6, 10, 2, 5};
        insertSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    private void insertSort(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            insert(arr, i);
        }
    }

    private void insert(int[] a, int n) {
        int i = n;
        int key = a[n];
        while (i > 0 && a[i - 1] > key) {
            a[i] = a[i - 1];
            i--;
        }
        a[i] = key;
    }
}
