package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 双队列模拟一个栈
 */
public class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    //哪个不为空就直接压入即可
    public void push(int x) {
        if(!q1.isEmpty()){
            q1.offer(x);
        } else if(!q2.isEmpty()){
            q2.offer(x);
        } else{
            q1.offer(x);
        }
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    //弹出时要将当前队列弹出，弹出的元素压入另一个队列中
    //要保存倒数第二个弹出的元素作为新的top
    public int pop() {
        if(q2.isEmpty()){
            while(q1.size() > 1){
                top = q1.remove();
                q2.offer(top);
            }
            return q1.remove();
        } else{
            while(q2.size() > 1){
                top = q2.remove();
                q1.offer(top);
            }
            return q2.remove();
        }
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}
