package Offer;

import java.util.Stack;

/**
 * 用栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 * 解题思路：队列先进先出，栈先进后出。
 *          入栈直接压入stack1即可，不管Stack2的情况
 *          出栈，如果stack2中有元素直接弹出即可，如果则没有将stack1中的元素全部倒入stack2，然后再弹出。
 */
public class StackToQueue_5 {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
