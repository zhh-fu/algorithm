package Offer;

import BasicConstructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 解题思路1:递归，左右子树的最大深度加上当前节点的深度1即可
 * 解题思路2：层序遍历。
 */
public class TreeDeep_38 {
    public int treeDepth_1(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        /**
         * curNum 当前遍历过的节点数目
         * nextCount 下一层的节点总数，与当前层有关
         * depth 深度
         */
        int curNum = 0,nextCount = 1,depth = 0;
        while(!q.isEmpty()){
            TreeNode head = q.poll();
            //当前层遍历过的节点数
            curNum++;
            if(head.left != null){
                q.add(head.left);
            }
            if(head.right != null){
                q.add(head.right);
            }
            //nextCount是在遍历上一层结束的时候确定的
            //此时nextCount是队列的总数目，是当前层的孩子总数，也就是下一层的节点数
            //当前层遍历完成时，队列中只存在下一层的节点
            //此时将当前层的遍历数目置0，depth++，nextCount = q.size();
            if(curNum == nextCount){
                nextCount = q.size();
                curNum = 0;
                depth++;
            }
        }
        return depth;
    }


    public int treeDepth_2(TreeNode root) {
        if(root == null) return 0;
        //左右子树的最大深度加上当前节点的深度1即可。
        return Math.max(treeDepth_2(root.left), treeDepth_2(root.right)) + 1;
    }

}
