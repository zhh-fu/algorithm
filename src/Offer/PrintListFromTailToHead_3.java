package Offer;

import BasicConstructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印数组；
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 思路1：使用栈，时间空间复杂度均为O(N)。
 * 思路2：递归，找到最后一个然后输出即可；
 * 思路3：反转链表
 */
public class PrintListFromTailToHead_3 {
    //栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //反转链表
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ListNode cur = listNode;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
