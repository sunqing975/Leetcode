package org.job.swordoffer.day01;

import java.util.Deque;
import java.util.LinkedList;
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {
    private Deque<Integer> s1;
    private Deque<Integer> s2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.s1 = new LinkedList<>();
        this.s2 = new LinkedList<>();
        this.s2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        s1.push(x);
        s2.push(Math.min(s2.peek(),x));
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.pop();
        int top = minStack.top();
        int min = minStack.min();
    }
}


