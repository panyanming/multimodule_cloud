package com.ming.eurekaclient.datastructure;

import java.util.Stack;

/**
 * Created by panyanming on 2019/12/13.
 */
public class Stackbrackets {
    public String removeBrackets(String content) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[content.toCharArray().length];
        for (int i = 0; i < content.toCharArray().length; i++) {
            if (content.charAt(i) == '(') {
                stack.push(i);
            }
            if (content.charAt(i) == ')') {
                arr[stack.pop()] = i;
            }
        }

        while (content.charAt(0) == '(' && (arr[0] == content.length() - 1)) {
            content = content.substring(1, arr[0]);
        }
        return content;
    }

    public static void main(String[] args) {
        String content = "0123456";
        content = content.substring(1, 7);
        System.out.println(content);
    }
}
