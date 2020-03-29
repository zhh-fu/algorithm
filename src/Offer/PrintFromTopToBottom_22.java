package Offer;

import BasicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上向下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 解题思路：其实就是二叉树的层序遍历,BFS。使用队列辅助。
 */
public class PrintFromTopToBottom_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode head = q.poll();
            list.add(head.val);
            if(head.left != null){
                q.add(head.left);
            }
            if(head.right != null){
                q.add(head.right);
            }
        }
        return list;
    }
}
