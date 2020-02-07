package AdvancedAlgorithm.MorrisTraversal;

import BasicConstructure.Node;
/**
 * 使用Morrris遍历完成前序、中序、后序遍历
 */
public class MorrisTraversal {

    //先序遍历，第一次到达该节点时进行打印
    public static void morrisPre(Node head) {
        if (head == null) return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            //存在左子树
            if (mostRight != null) {
                //右孩子不为空 或者 右孩子未指向cur，因为中途会将右孩子指向cur
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果右孩子为空
                //此时为cur第一次到达该节点,直接打印
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                }
                //上述条件导致此处的else意为右孩子指向cur
                else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
            else {
                //不存在直接向右移动
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    //中序遍历，第二次到达该节点时进行打印
    public static void morrisIn(Node head) {
        if (head == null) return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            //存在左子树
            if (mostRight != null) {
                //右孩子不为空 或者 右孩子未指向cur，因为中途会将右孩子指向cur
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果右孩子为空
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                }
                //上述条件导致此处的else意为右孩子指向cur
                else {
                    mostRight.right = null;
                    //此时为cur第二次到达该节点
                    //只要一个节点一旦向右移动就再也不可能回来
                    //对于只遍历了一次的节点来讲，第一次和第二次到达可视为一起。
                    System.out.println(cur.value);
                    cur = cur.right;
                }
            }
            else {
                //不存在直接向右移动，只遍历一次
                //对于只遍历了一次的节点来讲，第一次和第二次到达可视为一起。
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(7);
        head.left.right = new Node(8);
        head.right.left = new Node(9);
        head.right.right = new Node(10);
        morrisPre(head);
        System.out.println("**************************");
        morrisIn(head);
    }
}
