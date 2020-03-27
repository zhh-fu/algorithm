package Offer;

import BasicConstructure.TreeNode;

/**
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路：中序遍历的下一个节点是当前节点的右子树的最左孩子，从该点出发
 */
public class GetNextNode_57 {
    public TreeNode GetNext(TreeNode pNode){
        if(pNode == null) return null;
        TreeNode node = pNode;
        //如果右子树不为空，找到右子树的最左孩子
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        } else{
            //如果右子树为空，
            //找到当前节点是其父节点的左孩子的节点，返回其父节点即可
            //一种特殊情况，当前节点为最右节点，那么它的下一个节点就是null
            //因此如果找到了根节点后直接返回根节点的父节点null即可
            while(node.parent != null && node != node.parent.left){
                node = node.parent;
            }
            return node.parent;
        }
    }
}
