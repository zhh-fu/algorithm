package Offer;

import BasicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 解题思路1：递归，如果对称，
 *          当前节点的左右孩子值相同，左孩子的左孩子和右孩子的右孩子，左孩子的右孩子和右孩子的左孩子也要相同
 * 解题思路2：BFS，使用队列或者栈，一次成对存取存放
 */
public class IsSymmetricalTree_58 {
    //递归
    private boolean isSymmetrical_1(TreeNode pRoot){
        if(pRoot == null) return true;
        return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        //左孩子为空，判断右孩子是否为空
        if(left == null) return right == null;
        //此时左孩子必不为空
        if(right == null) return false;
        if(left.val != right.val) return false;
        //左孩子的左孩子和右孩子的右孩子
        //左孩子的右孩子和右孩子的左孩子
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    //BFS,使用队列或者栈均可，成对存取
    private static boolean isSymmetrical_2(TreeNode pRoot){
        if(pRoot == null) return true;
        TreeNode head = pRoot;
        Queue<TreeNode> q = new LinkedList<>();
        //成对存放
        q.add(head.left);
        q.add(head.right);
        TreeNode left = null;
        TreeNode right = null;
        while(!q.isEmpty()){
            //成对取出
            left = q.poll();
            right = q.poll();
            //null也在队列中占有位置
            //如果两个节点均为null，对称，没有孩子，直接进入下一轮循环
            if (left == null && right == null) continue;
            //有一个孩子为空即不成立
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            //成对儿存
            //左孩子的左孩子和右孩子的右孩子
            q.add(left.left);
            q.add(right.right);
            //左孩子的右孩子和右孩子的左孩子
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
