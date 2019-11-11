package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.ISortService;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/11/11.
 */
@Component
public class MergeSortImpl implements ISortService {
    @Override
    public boolean verify(Integer condition) {
        return condition.intValue()==1;
    }

    @Override
    public void sort() {
        System.out.println("归并排序");



    }
}
