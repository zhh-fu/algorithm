package Offer;

import BasicConstructure.ListNode;

/**
 * 反转链表
 * 输入一个链表将其反转，并输出返回后的头结点
 * 解题思路：反转，常规操作
 *          递归：很巧妙。
 */
public class ReverseList_15 {
    private ListNode reverseList_1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode reverseList_2(ListNode head) {
        //链表为空或者只有一个结点
        if(head == null || head.next == null) return head;
        //记住下一个结点
        ListNode next = head.next;
        //当前结点的下一个结点先让它为null，便于后续逆转
        head.next = null;
        //找到最末尾的节点，链表的逆转并不影响新头结点的存在
        ListNode HeadNode = reverseList_2(next);
        //将next原来的上一个结点赋值给next现在的下一个结点

        //整体可写为,head的信息系统帮你保存了,head从倒数第二个结点开始执行下面的操作
        //head.next.next = head;
        //head.next = null;
        next.next = head;
        return HeadNode;
    }
}
