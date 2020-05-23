package Leetcode;
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:你可以假设树中没有重复的元素。
 */

import BasicConstructure.TreeNode;

import java.util.HashMap;

public class BuildTree {
    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null) return null;
        //得到中序遍历的根节点位置，便于查询
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder,
                            int preStart, int preEnd,
                            int inStart, int inEnd){
        if (preStart > preEnd){
            return null;
        }
        //pre的第一个值必定是根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        //找到中序遍历中的根节点
        int inIndex = map.get(preorder[preStart]);
        //找到左子树的节点个数，很重要！！！！
        int size = inIndex - inStart;
        //重新定义左右子树的pre和in遍历数组
        root.left = helper(preorder, inorder, preStart + 1, preStart + size, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, preStart + size + 1, preEnd, inIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
       int[] preorder = {3,9,20,15,7};
       int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));
    }
}
