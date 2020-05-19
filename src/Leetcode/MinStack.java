package Leetcode;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        /*
        此处不能使用下面语句，因为可能会报空栈异常，特别是第一次压入元素
        minStack.push(Math.min(minStack.peek(),x));
         */
        if (minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        } else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        new MinStack().push(3);
    }
}
