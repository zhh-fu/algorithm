package Offer;

import BasicConstructure.ListNode;

/**
 * 合并两个有序链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表。
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * 解题思路1：双指针向下走，额外设置一个变量head记录头结点
 * 解题思路2：递归。
 */
public class MergeList_16 {
    private static ListNode merge_1(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = null;

        //先确定头结点
        if(p1.val >= p2.val){
            res = p2;
            p2 = p2.next;
        } else{
            res = p1;
            p1 = p1.next;
        }
        //记录头结点
        ListNode head = res;


        while(p1 != null && p2 != null){
            if(p1.val >= p2.val){
                res.next = p2;
                p2 = p2.next;
            } else{
                res.next = p1;
                p1 = p1.next;
            }
            res = res.next;
        }

        //p1为空的话，把res.next = p2即可，剩下的节点不用再遍历
        if(p1 == null){
            res.next = p2;
        }

        //p2为空的话，把res.next = p1即可，剩下的节点不用再遍历
        if(p2 == null){
            res.next = p1;
        }
        return head;
    }

    private static ListNode merge_2(ListNode list1, ListNode list2) {
        //basecase易知
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        //如果list1的值小于list2的值，
        //那么list1作为头，它的下一个节点就是list1剩余的节点和list2合并的头结点
        if(list1.val <= list2.val){
            list1.next = merge_2(list1.next, list2);
            return list1;
        } else{
            //如果list2的值小于list1的值，
            //那么list2作为头，它的下一个节点就是list2剩余的节点和list1合并的头结点
            list2.next = merge_2(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        System.out.println(merge_1(list1,list2).val);
    }
}
