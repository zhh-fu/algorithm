package Leetcode;

import BasicConstructure.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *  解题思路：很容易发现，展开后变为了前序遍历的结果
 */
public class FlattenBinaryTree {
    /*
    1、找到当前节点的左子树的最右孩子cur
    2、将当前节点的右子树变成cur的右孩子，将当前节点的左子树变成当前节点的右子树
    3、重复上述过程，直到当前节点为空
     */
    public void flatten_1(TreeNode root) {
        if(root == null) return;
        while(root != null){
            if(root.left == null){
                root = root.right;
            } else{
                TreeNode left = root.left;
                //找到当前节点左子树的最右孩子
                while(left.right != null){
                    left = left.right;
                }
                //最右孩子的右子树变成当前节点的右子树
                left.right = root.right;
                //当前节点的左子树变成当前节点的右子树
                root.right = root.left;
                //当前节点左子树置空
                root.left = null;
                root = root.right;
            }
        }
    }

}
