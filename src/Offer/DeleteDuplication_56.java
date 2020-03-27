package Offer;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 解题思路1：首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
 *             设置 before ，next 指针， before指针指向当前确定不重复的那个节点，
 *             而neext指针相当于工作指针，一直往后面搜索。
 * 解题思路2：利用一个队列存储未重复的元素，记录链表当前节点值，相同不入或尾部弹出，不同则加入
 *           单独设置一个节点记录链表头，链表尾置空
 */

import BasicConstructure.ListNode;
import java.util.LinkedList;

public class DeleteDuplication_56 {
    private ListNode deleteDuplication_1(ListNode pHead){
        //判断空或者只有一个节点的情况
        if(pHead == null || pHead.next == null) return pHead;

        //设置头节点，防止头部重复
        ListNode head = new ListNode(0);
        head.next = pHead;
        //before指向不重复的最后一个节点
        ListNode before = head;
        ListNode next = pHead;

        while(next != null){
            if(next.next != null && next.val == next.next.val){
                //一直找到最后一个不重复的节点
                while(next.next != null && next.val == next.next.val){
                    next = next.next;
                }
                next = next.next;
                before.next = next;
            }else{
                //向后遍历
                before = next;
                next = next.next;
            }
        }
        //此处的置空也可以不需要
        before.next = null;
        return head.next;
    }

    private static ListNode deleteDuplication_2(ListNode pHead){
        //队列存储非重复的节点
        LinkedList<ListNode> list = new LinkedList<>();
        //记录上个节点的值，以便判断
        int index = -1;
        ListNode head = pHead;
        while(head != null){
            //不同加入，相同弹出
            if(head.val != index){
                list.add(head);
            }else{
                list.pollLast();
            }
            index = head.val;
            head = head.next;
        }
        //记录头指针
        ListNode res = new ListNode(0);
        head = res;
        while(!list.isEmpty()){
            res.next = list.poll();
            res = res.next;
        }
        //此处必须要置空，因为可能后续可能还有重复的节点，所以要断开链接
        res.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next = new ListNode(5);
        pHead.next.next.next.next.next.next = new ListNode(5);
        System.out.println(deleteDuplication_2(pHead));
    }
}
