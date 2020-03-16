package Offer;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树要求左右子树的高度差不超过1，且左子树为平衡二叉树，右子树也为平衡二叉树
 * 根据上面的条件来判断
 * 解题思路1：从根到叶节点的递归
 * 解题思路2：从根到叶节点的递归，稍微优化
 * 解题思路3：递归，子树不平衡直接返回即可
 */

import BasicConstructure.TreeNode;

public class IsBalancedTree_39 {
    public boolean isBalanced_Solution_1(TreeNode root) {
        if(root == null) return true;
        /*
        1、左右子树的高度差不超过1
        2、左子树为平衡二叉树
        3、右子树为平衡二叉树
         */
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 &&
                isBalanced_Solution_1(root.left) && isBalanced_Solution_1(root.right);
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        //左右子树的最大深度+1
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }

    boolean isBalanced = true;
    public boolean isBalanced_Solution_2(TreeNode root) {
        if(root == null) return true;
        getDepth_1(root);
        return isBalanced;
    }

    //稍微优化
    private int getDepth_1(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getDepth_1(root.left);
        int right = getDepth_1(root.right);

        //遍历完成时只要isBalanced为false就不平衡
        if(Math.abs(right - left) > 1){
            isBalanced = false;
        }
        return Math.max(getDepth_1(root.left),getDepth_1(root.right)) + 1;
    }

    //子树不平衡直接返回
    //最终返回树的高度
    public boolean isBalanced_Solution_3(TreeNode root) {
        if(root == null) return true;

        return getDepth_3(root) != -1;
    }

    private int getDepth_3(TreeNode root){
        if(root == null){
            return 0;
        }
        //左树不平衡直接返回
        int left = getDepth_3(root.left);
        if(left == -1) return -1;
        //右树不平衡直接返回
        int right = getDepth_3(root.right);
        if(right == -1) return -1;

        //左右都平衡，判断高度差
        if(Math.abs(right - left) > 1){
            return -1;
        }
        //左右都平衡，返回当前节点的高度
        return Math.max(getDepth_3(root.left),getDepth_3(root.right)) + 1;
    }
}
