package Offer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解题思路1：使用hashmap，key为原节点，value为复制的节点
 * 解题思路2：在每个节点的后面插入它复制的节点，然后处理，最后拆分
 */
public class ListClone_25 {
    //使用额外空间，时间空间复杂度均为O(N)
    public RandomListNode clone_1(RandomListNode pHead){
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while(cur != null){
            //放入hashmap中
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        //记录头结点，记得为复制的头结点
        RandomListNode head = map.get(cur);
        while(cur != null){
            //原节点的复制节点的下一个结点等于原结点的下一个结点的value值
            map.get(cur).next = map.get(cur.next);
            //原节点的复制节点的随机结点等于原结点的随机结点的value值
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return head;
    }

    public RandomListNode clone_2(RandomListNode pHead){
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        RandomListNode next = null;
        //复制并重组原链表
        while (cur != null){
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        cur = pHead;
        //复制随机节点
        while(cur != null){
            //注意此处的判断
            cur.next.random = cur.random!=null? cur.random.next:null;
            cur = cur.next.next;
        }

        cur = pHead;
        RandomListNode head = cur.next;

        //拆分链表
        while(cur != null){
            next = cur.next.next;
            //注意非空判断
            cur.next.next = next!=null?next.next:null;
            cur.next = next;
            cur = next;
        }
        return head;

    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args){
        RandomListNode pHead1 = new RandomListNode(1);
        RandomListNode pHead2 = new RandomListNode(2);
        RandomListNode pHead3 = new RandomListNode(3);
        pHead1.next = pHead2;
        pHead2.next = pHead3;
        pHead1.random = pHead3;
        pHead2.random = pHead1;
        pHead3.random = pHead2;
        System.out.println(new ListClone_25().clone_2(pHead1));
    }
}
