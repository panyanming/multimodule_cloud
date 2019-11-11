package com.ming.eurekaclient.serivce;

/**
 * Created by panyanming on 2019/11/11.
 */
public interface ISortService extends ISPI<Integer> {
    default void execute(int level){
        sort();
    }

    void sort();
}
