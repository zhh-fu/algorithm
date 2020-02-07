package AdvancedAlgorithm.Tree;

import BasicConstructure.Node;

/**
 * 一棵二叉树的最大搜索子树
 * 求一棵树的最大搜索子树，需要遍历以每一个节点为头的最大搜索子树。
 * 对于某一个节点来讲，左子树是一棵搜索二叉树，右树也是一颗搜索二叉树。
 * 左子树的最大值要要小于当前节点，右子树的最小值要大于当前节点，
 * 再加上我本身这个节点，就构成了一棵搜索二叉树。
 */
public class BiggestSubBSTInTree {

    private static class ReturnInfo{
        /**
         * 共需返回四条信息
         * @size       子树上最大搜索二叉子树的大小
         * @headValue  子树上最大搜索二叉子树的头部
         * @max        子树上的最大值
         * @min        子树上的最小值
         */
        private int size;
        private Node head;
        private int max;
        private int min;

        public ReturnInfo(int size,Node head,int max,int min){
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnInfo process(Node head){
        if (head == null){
            //最大值和最小值的设置是为了不给上级返回干扰信息
            return new ReturnInfo(0,null,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        //认为左右子树都是黑盒子，会返回信息
        Node left = head.left;
        ReturnInfo leftSubTreeInfo = process(left);
        Node right = head.right;
        ReturnInfo rightSubTreeInfo = process(right);

        //可能性三
        //如果可能性三不成立那么 includeItself 为 0
        int includeItself = 0;
        //左最大搜索二叉树子树的头部是头节点左孩子
        //右最大搜索二叉树子树的头部是头节点右孩子
        //左最大搜索二叉树子树的最大值小于当前头节点的值
        //右最大搜索二叉树子树的最大值大于当前头节点的值
        if (leftSubTreeInfo.head == left
                && rightSubTreeInfo.head == right
                && leftSubTreeInfo.max < head.value
                && rightSubTreeInfo.min > head.value){
            includeItself = leftSubTreeInfo.size + rightSubTreeInfo.size + 1;
        }

        //可能性一和可能性二
        //p1 p2 认为最大搜索二叉子树在左/右子树上，取出size
        int p1 = leftSubTreeInfo.size;
        int p2 = rightSubTreeInfo.size;

        int maxSize = Math.max(Math.max(p1,p2),includeItself);

        //判断最大子树的头节点
        Node NodeHead = p1 > p2 ? leftSubTreeInfo.head : rightSubTreeInfo.head;
        if (maxSize == includeItself){
            NodeHead = head;
        }

        //返回左子树的最大值和右子树的最小值
        return new ReturnInfo(maxSize, NodeHead,
                Math.max(Math.max(leftSubTreeInfo.max,rightSubTreeInfo.max),head.value),
                Math.min(Math.min(leftSubTreeInfo.min,rightSubTreeInfo.min),head.value));
    }
}
