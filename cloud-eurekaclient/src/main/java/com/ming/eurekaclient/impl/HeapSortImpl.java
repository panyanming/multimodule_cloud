package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/11/12.
 */
@Component
public class HeapSortImpl implements ISortService {
    @Override
    public boolean verify(Integer condition) {
        return condition==5;
    }

    @Override
    public void sort() {
        System.out.println("堆排序,时间复杂度是O(nlogn)");
        int arr[] = new int[]{3, 8, 7, 9, 6, 10, 2, 5};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void heapSort(int[] arr) {
        buildHeap(arr);
        int k = arr.length-1;
        while (k > 0) {
            swap(arr, 0, k);
            --k;
            heapfiy(arr,k,0);
        }
    }


    private void buildHeap(int[] arr) {
        for (int i = (arr.length-1) / 2; i >= 0; i--) {
            heapfiy(arr, arr.length - 1, i);
        }
    }

    /**
     * 对某个元素进行堆化，让每一个节点的值都大于它的子节点
     *
     * @param arr
     * @param n   数组的元素个数
     * @param i   要堆化元素的索引
     */
    private void heapfiy(int[] arr, int n, int i) {
        int max = i;
        while (true) {
            if ((2 * i)+1 <= n && arr[(2 * i)+1] > arr[i]) max = (2 * i)+1;
            if (2 * (i + 1) <= n && arr[max] < arr[2 * (i + 1)]) max = 2 * (i + 1);
            if (max == i) {
                break;
            } else {
                swap(arr, i, max);
            }
            i = max;
        }
    }

    private void swap(int[] arr, int i, int max) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }


}
