package Offer;

import BasicConstructure.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树转换为双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：递归法:在两个递归的中间进行判断
 *                  节点的左右指针代表链表的前后指针。
 *                  真正头指针的左右指针不能动，否则会破坏链表的连贯性，出现由头直接指向尾的情况。
 *          非递归法：中序遍历，右 中 左，返回的就是头结点
 *                    如果中序遍历左中右需要记录前一个节点。
 */

public class TreeConvertToList_26 {
    TreeNode realHead = null;
    TreeNode endHead = null;
    private TreeNode convert_1(TreeNode pRootOfTree) {
        Helper(pRootOfTree);
        return realHead;
    }

    private void Helper(TreeNode pRootOfTree){
        if(pRootOfTree == null) return;
        Helper(pRootOfTree.left);

        if(endHead == null){
            endHead = pRootOfTree;
            realHead = pRootOfTree;
        } else{
            //注意此处的表达，因为节点的赋值全部都是引用，
            //即使当前节点的引用改变了，也不会改变已经建立好的引用节点之间的关系
            endHead.right = pRootOfTree;
            pRootOfTree.left = endHead;
            endHead = pRootOfTree;
        }

        Helper(pRootOfTree.right);
    }

    public TreeNode convert_2(TreeNode pRootOfTree) {
        TreeNode realHead = null;
        if(pRootOfTree == null) return pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        while(pRootOfTree != null || !stack.isEmpty()){
            if(pRootOfTree != null){
                stack.push(pRootOfTree);
                //注意先是右孩子
                pRootOfTree = pRootOfTree.right;
            } else{
                //此处不能创建新的节点
                //即不能TreeNode node = stack.pop();
                //否则会报空指针异常
                pRootOfTree = stack.pop();
                //此处的逻辑不能使用非递归的逻辑，否则反向指针会报错
                if(realHead == null){
                    realHead = pRootOfTree;
                } else{
                    realHead.left = pRootOfTree;
                    pRootOfTree.right = realHead;
                    realHead = pRootOfTree;
                }
                pRootOfTree = pRootOfTree.left;
            }
        }
        return realHead;
    }
}
