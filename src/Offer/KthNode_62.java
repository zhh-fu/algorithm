package Offer;

import BasicConstructure.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的第K个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * 解题思路：中序遍历，加入一个判断即可，递归版不太明白
 */
public class KthNode_62 {
    //非递归版中序遍历
    public static TreeNode KthNode_1(TreeNode pRoot, int k){
        if(pRoot == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        int index = 0;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            //在第二次到达该节点的时候进行数量加1
            index++;
            if(index == k) return node;
            node = node.right;
            /*
            另一种表达，一样的效果
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                index++;
                if(index == k) return node;
                node = node.right;
            }
             */
        }
        return null;
    }

    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot != null){ //中序遍历寻找第k个
            TreeNode node = KthNode(pRoot.left,k);
            //精髓所在，当node == null的时候证明一直没有找到
            //当node 不为null的时候证明找到了，然后逐级向上返回
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode(pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(new KthNode_62().KthNode(root,3));
    }
}
