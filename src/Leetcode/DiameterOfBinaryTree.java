package Leetcode;

import BasicConstructure.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 首先我们知道一条路径的长度为该路径经过的节点数减一，
 * 所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
 * 而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
 * 那么 某节点的路径长度 = 左子树的深度 + 右子树的深度
 *
 */
public class DiameterOfBinaryTree {
    //全局变量记录最大值
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return ans;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        //当前长度 和 当前节点的左右子树的深度和 的 最大值
        ans = Math.max(ans, left + right);
        //返回树的深度
        return Math.max(left, right) + 1;
    }
}
