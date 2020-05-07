package Leetcode;

import BasicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode parent = q.poll();
                subList.add(parent.val);
                if (parent.left != null){
                    q.offer(parent.left);
                }

                if (parent.right != null){
                    q.offer(parent.right);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
