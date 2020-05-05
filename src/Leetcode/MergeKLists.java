package Leetcode;

import BasicConstructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {
    /*
    时间复杂度为O(NlogN)，主要是在快排上
    空间复杂度为O(N)
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        for (int i=0;i<lists.length;i++){
            ListNode head = lists[i];
            //此处不为空的时候才会加入
            //如果全部都是空，那么list中没有元素，
            // size()为0，但是list并不为null
            while(head != null){
                list.add(head);
            }
        }
        //时间复杂度杀手，O(NlogN)
        Collections.sort(list, new Compare());
        //list不可能为null，因为list的底层是一个数组
        //因此如果需要判定是否为空，那么需要使用list.size() == 0来进行
        if(list.size() == 0) return null;
        ListNode head = list.get(0);
        ListNode res = head;
        for (int i=1;i<list.size();i++){
            head.next = list.get(i);
            head = head.next;
        }
        return res;
    }

    /*
    时间复杂度：考虑优先队列中的元素不超过k个，那么插入和删除的时间代价为O(logk)，
               这里最多有 N 个点，对于每个点都被插入删除各一次，
               故总的时间代价即渐进时间复杂度为O(N×logk)
    空间复杂度：这里用了优先队列，优先队列中的元素不超过K个，
               故渐进空间复杂度为O(k)。

     */
    public static ListNode mergeKLists_2(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //小根堆，维护当前链表头结点的最小值
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Compare());
        for (ListNode node : lists){
            //将所有头结点加入
            if (node != null){
                pq.add(node);
            }
        }
        //设置头
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            //当前的最小元素获取到后，再去获取它的下一个元素
            //由小根堆来维护最小值
            if (node.next != null){
                pq.add(node.next);
            }
        }
        return res.next;
    }

    static class Compare implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode[] lists = {head};
        System.out.println(mergeKLists_2(lists));
    }
}
