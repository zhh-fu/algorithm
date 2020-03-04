package Offer;

import BasicConstructure.ListNode;

import java.util.Stack;

/**
 * 输出链表倒数第K个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 解题思路1：使用栈
 * 解题思路2：反转链表
 * 解题思路3：快慢双指针p1,p2. p1先走k-1，然后p1,p2一起走，当p1走到结尾的时候，p2就是倒数第k个结点。
 */
public class FindKthToTail_14 {
    private ListNode findKthToTail_1(ListNode head, int k) {
        if (k < 1) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
            length++;
        }
        if(k > length){
            return null;
        } else{
            while(--k != 0){
                stack.pop();
            }
        }
        return stack.pop();
    }

    private ListNode findKthToTail_2(ListNode head,int k) {
        if (k < 1) return null;
        ListNode cur = head;
        ListNode pre = null;
        int length = 0;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            length++;
        }

        if(k > length){
            return null;
        } else {
            while (--k != 0) {
                pre = pre.next;
            }
        }
        return pre;
    }

    private ListNode findKthToTail_3(ListNode head,int k) {
        if (k < 1 || head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        //p1先走 k-1 步，所以这个地方是 k>1
        while(k > 1){
            if(p1.next != null){
                p1 = p1.next;
                k--;
            } else{
                //如果k还没有完p1就走到了最后，那么k大于结点的数量
                return null;
            }
        }
        //p1 p2 同步走，p1到最后时，p2就是倒数第k个结点
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    int count = 0;
    private ListNode findKthToTail_4(ListNode head,int k) {
        if (k < 1 || head == null) return null;
        ListNode node = findKthToTail_4(head.next,k);
        //从倒数第一个开始计数，此时的node不为空
        if(node != null){
            return node;
        }
        count++;
        if(count == k){
            return head;
        } else{
            return null;
        }
    }
}
