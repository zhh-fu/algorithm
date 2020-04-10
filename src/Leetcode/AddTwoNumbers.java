package Leetcode;

import BasicConstructure.ListNode;

import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    //转化为数字计算会导致长度溢出，需要用long long
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        Stack<Long> stack1 = new Stack<>();
        Stack<Long> stack2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        long count1 = 0,count2 = 0;
        while(p1 != null){
            stack1.push((long) p1.val);
            count1++;
            p1 = p1.next;
        }
        while(p2 != null){
            stack2.push((long) p2.val);
            count2++;
            p2 = p2.next;
        }

        long step = Math.abs(count1 - count2);
        long res = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(count1 > count2){
                while(step != 0){
                    res = res * 10 + stack1.pop();
                    step--;
                }
            } else{
                while(step != 0){
                    res = res * 10 + stack2.pop();
                    step--;
                }
            }
            res = res * 10 + stack1.pop() + stack2.pop();
        }
        ListNode rp = new ListNode((int) res % 10);
        ListNode head = rp;
        res = res / 10;
        while(res != 0){
            rp.next = new ListNode((int) res % 10);
            res /= 10;
            rp = rp.next;
        }
        return head;
    }

    //链表进位相加
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode res = root;
        int mod = 0;
        ListNode p1 = l1, p2 = l2;
        while(p1 != null || p2 != null || mod != 0){
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;
            int sum = v1 + v2 + mod;
            //进位
            mod = sum / 10;

            //当前位置
            ListNode sumNode = new ListNode(sum % 10);
            res.next = sumNode;
            res = res.next;

            //注意此处的判断方法
            //如果p1或p2已经为null则不需要更新，因为没有next
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        return root.next;
    }
}
