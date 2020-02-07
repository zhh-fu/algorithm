package AdvancedAlgorithm.MorrisTraversal;

import BasicConstructure.Node;
import BasicConstructure.TreeNode;

/**
 * Morris遍历的整体原则。时间复杂度为O(N)，空间复杂度为O(1)。
 * 1、如果cur 无左孩子，cur 向右移动 即 cur = cur.right
 * 2、如果cur 有左孩子，找到cur左子树上的最右节点，记为 mostright
 *  1)如果mostright的右指针指向null,让其指向cur ，cur向左移动。即
 *      mostright.right = cur;
 *      cur = cur.left;
 *  2)如果mostright的右指针指向cur，让其指向null，cur向右移动。即
 *      mostright.rigth = null;
 *      cur = cur.right;
 */
public class MorrisAlgorithm {

    public static void morris(Node head){
        if (head == null) return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            //存在左子树
            if (mostRight != null){
                //右孩子不为空 或者 右孩子未指向cur，因为中途会将右孩子指向cur
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //如果右孩子为空
                //第一次到达该节点
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }
                //上述条件导致此处的else意为右孩子指向cur
                //第二次到达该节点
                else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
            else {
                //不存在直接向右移动
                //第一次到达和第二次到达视为相同
                cur = cur.right;
            }
        }
    }
}
