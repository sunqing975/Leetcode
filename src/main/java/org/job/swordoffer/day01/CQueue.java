package org.job.swordoffer.day01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 我的解题思路为，一个两个栈，一个栈用于接受数据，另一个用于出栈
 * 也就是先用s1接受数据。数据接收完毕后，将s1的数据全部出栈到s2
 * 也就实现了先进先出的队列
 */
class CQueue {
    // private final Stack<Integer> s1;
    // private final Stack<Integer> s2;
    //
    // public CQueue() {
    //     this.s1 = new Stack<>();
    //     this.s2 = new Stack<>();
    // }
    //
    // public void appendTail(int value) {
    //     s1.push(value);
    // }
    //
    // public int deleteHead() {
    //     if (s1.empty()) {
    //         return -1;
    //     }
    //     while (!s1.empty()){
    //         s2.push(s1.pop());
    //     }
    //     int result = s2.pop();
    //     if (!s2.empty()){
    //         while (!s2.empty()){
    //             s1.push(s2.pop());
    //         }
    //     }
    //     return result;
    // }

    private final Deque<Integer> in;
    private final Deque<Integer> out;

    public CQueue() {
        this.in = new ArrayDeque<>();
        this.out = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (!in.isEmpty()) {
                extracted();
            } else {
                return -1;
            }
        }
        return out.pop();
    }

    private void extracted() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
} 

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */