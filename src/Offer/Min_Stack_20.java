package Offer;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 * 解题思路：时间复杂度为O(1)，则使用辅助栈存储最小值，也就是单调栈
 *          使用一个数组存储栈中的每个元素。
 */

import java.util.Stack;

public class Min_Stack_20 {
    private int size = 0;
    private Stack<Integer> minStack = new Stack<>();
    private Integer[] element = new Integer[100];
    private int min = Integer.MIN_VALUE;

    public void push(int node) {
        element[size++] = node;
        if(minStack.isEmpty() || minStack.peek() > node){
            minStack.push(node);
            min = node;
        } else{
            minStack.push(min);
        }
    }

    public void pop() {
        if(size >= 1){
            minStack.pop();
            element[size - 1] = null;
            if(minStack.isEmpty()){
                min = Integer.MIN_VALUE;
            } else{
                min = minStack.peek();
            }
        }
    }

    public int top() {
        if(size >= 1) return element[size - 1];
        return (Integer) null;
    }

    public int min() {
        return min;
    }
}
