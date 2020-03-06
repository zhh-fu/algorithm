package Offer;

import BasicConstructure.TreeNode;

import java.util.Stack;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 解题思路1：递归，不为空时直接交换左右子树。
 *          因为二叉树的结构，在左右子树交换的时候其子结构也会随之交换
 *
 * 解题思路2：使用栈，边更改其结构，边压栈
 */
public class MirrorOfTree_18 {

    private void mirror_1(TreeNode root) {
        TreeNode tmp = null;
        if(root != null) {
            //左右节点交换，在交换时它们的孩子也随之交换
            tmp = root.right;
            root.right = root.left;
            root.left = tmp;

            //然后对左右孩子进行交换
            if (root.left != null){
                mirror_1(root.left);
            }
            if (root.right != null){
                mirror_1(root.right);
            }
        }
    }

    //第一版优化
    private void mirror_2(TreeNode root) {
        //为空直接返回
        if(root == null) return;

        //左右节点交换，在交换时它们的孩子也随之交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        //然后对左右孩子进行交换
        mirror_2(root.left);
        mirror_2(root.right);
    }

    //使用栈
    public void Mirror(TreeNode root) {
        //需加入下面的判断，若无，则应该按照while循环中进行判断
        //if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //此处需要加入stack.peek() != null的判断，否则空树无法通过
        while(!stack.isEmpty() && stack.peek() != null){
            TreeNode head = stack.pop();
            //左右子树都不为空的时候，也可以直接交换不进行空的判定
            TreeNode tmp = head.right;
            head.right = head.left;
            head.left = tmp;

            /*
            if(head.left != null || head.right != null){
                TreeNode tmp = head.right;
                head.right = head.left;
                head.left = tmp;
            }
             */

            //然后对左右子树进行操作
            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right != null){
                stack.push(head.right);
            }
        }
    }


}
