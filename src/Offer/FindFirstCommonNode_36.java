package Offer;
/**
 * 两个链表的第一个节点
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 解题思路：左神初级班讲过。考虑有环无环两种情况,为方法1；
 *          直接考虑无环为方法2.
 *
 */

import BasicConstructure.ListNode;

public class FindFirstCommonNode_36 {
    public ListNode findFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        ListNode p1 = isCircleNode(pHead1);
        ListNode p2 = isCircleNode(pHead2);
        ListNode p3 = null;
        if(p1 == null && p2 == null){
            int a = 0;
            p1 = pHead1;
            p2 = pHead2;
            while(p1 != null){
                p1 = p1.next;
                a++;
            }
            while(p2 != null){
                p2 = p2.next;
                a--;
            }
            p1 = a > 0 ? pHead1 : pHead2;
            p2 = a > 0 ? pHead2 : pHead1;

            a = Math.abs(a);
            while(a != 0){
                p1 = p1.next;
                a--;
            }

            while(p1 != null){
                if(p1 == p2) return p1;
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;
        } else if(p1 != null && p2 != null){
            if(p1 == p2){
                int a = 0;
                p3 = p1;
                p1 = pHead1;
                p2 = pHead2;
                while(p1 != p3){
                    p1 = p1.next;
                    a++;
                }
                while(p2 != p3){
                    p2 = p2.next;
                    a--;
                }
                p1 = a > 0 ? pHead1 : pHead2;
                p2 = a > 0 ? pHead2 : pHead1;
                a = Math.abs(a);
                while(a != 0){
                    p1 = p1.next;
                    a--;
                }

                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
            else{
                p3 = p1;
                p1 = p1.next;
                while(p1 != p3){
                    if(p1 == p2){
                        return p1;
                    }
                    p1 = p1.next;
                }
                return null;
            }
        } else{
            return null;
        }
    }

    public ListNode isCircleNode(ListNode head){
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while(p1 != p2){
            if(p1.next == null || p2.next == null || p2.next.next == null) {
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p2 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public ListNode findFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
