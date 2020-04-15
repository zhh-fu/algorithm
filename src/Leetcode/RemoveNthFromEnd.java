package Leetcode;

import BasicConstructure.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 0) return null;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p1 = root, p2 = root;
        int length = 0;
        while(p1 != null){
            p1 = p1.next;
            length++;
        }
        p1 = root;

        while(n != 0){
            p1 = p1.next;
            n--;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode next = p2.next.next;
        p2.next = next;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(removeNthFromEnd(head, 3).val);
    }
}
