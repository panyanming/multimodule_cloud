package com.ming.eurekaclient.datastructure;

import com.ming.model.Node;

/**
 * Created by panyanming on 2019/12/31.
 */
public class PostArray {

    public Node postArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int less = -1;
        int more = end;
        for (int i = 0; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        Node root = new Node(arr[end]);
        root.setLeft(postArrayToBST(arr, start, less));
        root.setRight(postArrayToBST(arr, more, end - 1));
        return root;
    }

    public void postOrder(Node root) {
        if(root==null) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData()+" ");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 5, 9, 11, 10, 7};
        Node root = new PostArray().postArrayToBST(arr, 0, arr.length - 1);
        new PostArray().postOrder(root);
    }
}
