package Offer;

import BasicConstructure.TreeNode;

import java.util.Arrays;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 解题思路：前序遍历的头节点就是二叉树的根节点
 *          那么在中序遍历中，头节点左边的节点都是其左子树，头结点右边的节点都是其右子树
 *          使用递归进行这一个过程
 */

public class ReConstructBinaryTree_4 {
    //解法1：好理解
    public TreeNode reConstructBinaryTree_1(int [] pre,int [] in) {
        //空树
        if(pre == null || pre.length == 0) return null;
        //只有一个节点
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length == 1) return root;

        //找到中序遍历中的根节点位置
        int rootIndex = -1;
        for(int i=0;i<in.length;i++){
            if(in[i] == pre[0]){
                rootIndex = i;
                break;
            }
        }

        //二叉树的左右子树都已经创建好，直接加上即可
        root.left = reConstructBinaryTree_1(Arrays.copyOfRange(pre,1,rootIndex+1), Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree_1(Arrays.copyOfRange(pre,rootIndex+1,pre.length), Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

    //解法2：不太好理解
    public TreeNode reConstructBinaryTree_2(int [] pre,int [] in) {
        if(pre == null || pre.length == 0) return null;
        if(pre.length == 1) return new TreeNode(pre[0]);;

        return reConstructTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode reConstructTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn){
        //二者可以相同，此时指向同一个节点
        if(startPre > endPre || startIn > endIn){
            return null;
        }

        //根节点
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i=0;i<in.length;i++){
            //找到中序遍历的头结点
            if(in[i] == pre[startPre]){
                //startPre+1 前序遍历的数组必定是从startPre+1开始
                //startPre+(i-startIn)  i-startIn是中序遍历情况下根节点的左子树的节点数
                //因为i为根节点，startIn为中序遍历的开头，那么节点数目就是i-startIn，也就是在前序中的偏移量
                //那么startPre+(i-startIn)就是在前序遍历中左子树的最后位置
                //那么startPre+(i-startIn)+1就是在前序遍历中右子树的开始位置
                //中序遍历好理解
                root.left = reConstructTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}
