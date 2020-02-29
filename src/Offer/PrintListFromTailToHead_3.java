package Offer;

import BasicConstructure.LinkNode;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头答应数组；
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 思路1：使用栈，时间空间复杂度均为O(N)。
 * 思路2：递归，找到最后一个然后输出即可；
 * 思路3：反转链表
 */
public class PrintListFromTailToHead_3 {
    //栈
    public ArrayList<Integer> printListFromTailToHead(LinkNode listNode) {
        Stack<Integer> stack = new Stack<>();
        LinkNode head = listNode;
        while (head != null){
            stack.push(head.value);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //反转链表
    public ArrayList<Integer> printListFromTailToHead1(LinkNode listNode) {
        LinkNode cur = listNode;
        LinkNode pre = null;
        while (cur != null){
            LinkNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(pre.value);
            pre = pre.next;
        }
        return list;
    }

    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> printListFromTailToHead2(LinkNode listNode) {
        if (listNode != null){
            printListFromTailToHead2(listNode.next);
            list.add(listNode.value);
        }
        return list;
    }
}
