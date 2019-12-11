package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.IOneStepStatckService;
import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * Created by panyanming on 2019/12/11.
 */
@Component
public class OneStepStackImpl implements IOneStepStatckService {

    @Override
    public boolean verify(Integer condition) {
        return condition>0;
    }

    @Override
    public int[][] getNearLess(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack=new Stack<>();
        int[][] res = new int[n][2];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int index = stack.pop();
                int left = stack.isEmpty()?-1:stack.peek();
                res[index][0]=left;
                res[index][1]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            int left = stack.isEmpty()?-1:stack.peek();
            res[index][0]=left;
            res[index][1]=-1;
        }

        return res;
    }
}
