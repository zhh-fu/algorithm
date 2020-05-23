package Leetcode;

import BasicConstructure.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        fast = head;
        while (slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        System.out.println(new IsPalindrome().isPalindrome(head));
    }
}
