package com.ming.eurekaclient.serivce;

/**
 * Created by panyanming on 2019/12/11.
 */
public interface IOneStepStatckService extends ISPI<Integer> {
    default int[][] execute(int condition,int[] arr) {
        return getNearLess(arr);
    }

    int[][] getNearLess(int[] arr);
}
