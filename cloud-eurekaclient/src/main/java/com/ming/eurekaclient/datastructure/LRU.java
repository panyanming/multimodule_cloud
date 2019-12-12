package com.ming.eurekaclient.datastructure;

import java.util.LinkedList;

/**
 * Created by panyanming on 2019/12/12.
 */
public class LRU {

    private Node head;
    private static final int capcity = 3;
    private int count;


    public LRU() {
        this.head = new Node();
    }


    public void add(int data) {
        //查找前一个节点是否存在
        Node prev = findPrevNode(data);
        if (prev != null) {
            //存在，断开与前后节点的联系
            prev.next = prev.next.next;
            //设置为头节点
            setHead(data);
            //数量+1
            count++;
        }

        //不存在，判断容量是否满了，未满，设置为头节点，已满，删除最后节点，设置为头节点
        else {
            if (count == capcity) {
                //删除最后节点
                delTail();
                //设置为头节点
                setHead(data);
                //数量+1
                count++;
            } else {
                //设置为头结点
                setHead(data);
                //数量+1
                count++;
            }
        }
    }

    private void delTail() {
        Node pre = head;
        while (pre.next.next != null) {
            pre = pre.next;
        }
        Node tail = pre.next;
        pre.next = null;
        tail = null;
        count--;
    }

    private void setHead(int data) {
        Node node = new Node(data, head.next);
        head.next = node;
    }

    private Node findPrevNode(int data) {
        Node pre = head;
        while (pre.next != null) {
            if (pre.next.data == data) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    public String toString() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data);
            sb.append(" ");
            node =node.next;
        }
        return sb.toString();
    }


    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }
    }


}
