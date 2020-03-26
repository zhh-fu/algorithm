package Offer;

import BasicConstructure.ListNode;

import java.util.HashSet;

/**
 * 链表中环的入口节点
 *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解题思路1：使用set
 * 解题思路2：快慢指针，每次快的走两步，慢的走一步，快慢相遇则快指针回到开头，
 * 双方都一次走一步，再次相遇即为交点
 */
public class EntryNodeOfLoop_55 {
    //快慢指针
    public ListNode EntryNodeOfLoop_1(ListNode pHead){
        //注意这个地方pHead.next == null，防止只有一个节点的情况发生
        if(pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        //注意此处不能使用p1 == p2判定而要使用null
        //此外判断的依据是p2 != null && p2.next != null
        //如果没有环则可能 p2.next.next != null无法达到判决条件
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        //返回快指针
        return p2;
    }

    public ListNode EntryNodeOfLoop_2(ListNode pHead){
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = pHead;
        while(p1 != null){
            if(set.contains(p1)){
                return p1;
            }else{
                set.add(p1);
            }
            p1 = p1.next;
        }
        return p1;
    }
}
