package Leetcode;

import BasicConstructure.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *  
 * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodePairs {
    //迭代版本
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        //pre用于保存上一对节点的后一个节点
        //因为此节点需要和下一个节点进行连接
        ListNode cur = head, pre = new ListNode(-1);
        //必定为头结点
        ListNode res = head.next;
        //必须要成对才能进行
        while (cur != null && cur.next != null){
            //更新前后关系
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = cur;
            //更新与上一对节点的关系
            pre.next = tmp;
            //更新pre
            pre = cur;
            //更新当前节点
            cur = cur.next;
        }
        return res;
    }

    //递归版本
    public ListNode swapPairs_1(ListNode head) {
        if (head == null || head.next == null) return head;

        //分别记录两个节点
        ListNode first = head;
        ListNode second = head.next;

        //前一对节点的下一个节点就是后一对节点的新头
        first.next = swapPairs_1(second.next);
        //当前一对节点的头就是当前的第二个节点
        second.next = first;

        //返回当前头即可
        return second;
    }
}
