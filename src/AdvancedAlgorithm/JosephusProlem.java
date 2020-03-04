package AdvancedAlgorithm;

import BasicConstructure.ListNode;

/**
 * 约瑟夫环形链表问题
 */
public class JosephusProlem {
    public static ListNode josephusProlem2(ListNode head, int m){
        if (head == null || head.next == head || m < 1) {
            return head;
        }

        ListNode cur = head.next;
        int tmp = 1; // tmp -> list size
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }

        //活着的编号
        tmp = getLive(tmp, m); // tmp -> service node position
        //找到该编号位置的节点
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    //里面的为旧的节点序号
    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        //里面为新的节点序号
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

    public static ListNode josephusProblem1(ListNode head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        ListNode last = head;
        //找到最尾的节点
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}

