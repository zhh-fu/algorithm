package AdvancedAlgorithm.Tree;

import BasicConstructure.Node;

/**
 * 求一棵二叉树的最大路径
 */
public class MaxPathInTree {

    private static class ReturnInfo{
        private int maxDistance;
        private int height;

        public ReturnInfo(int maxDistance,int height){
            this.maxDistance = maxDistance;
            //height 在决策的过程中需要
            this.height = height;
        }
    }

    public static ReturnInfo process(Node head){
        if (head == null){
            return new ReturnInfo(0,0);
        }

        //获取左右子树黑盒子的信息
        ReturnInfo leftSubInfo = process(head.left);
        ReturnInfo rightSubInfo = process(head.right);

        //情况一 p1 最大距离在左子树上
        //情况二 p2 最大距离在右子树上
        //情况三 includeItself 最大距离为左子树的高度加上右子树的高度再加上本身的1
        //因为情况三发生时左右子树必然到达自己的最大深度
        //此处之所以不能用左右子树的最大距离计算是因为会出现重复加的情况
        int p1 = leftSubInfo.maxDistance;
        int p2 = rightSubInfo.maxDistance;
        int includeItself = leftSubInfo.height + rightSubInfo.height + 1;

        //子树的最大距离和深度
        int resultDistance = Math.max(Math.max(p1,p2),includeItself);
        int resultHeight = Math.max(leftSubInfo.height,rightSubInfo.height) + 1;

        return new ReturnInfo(resultDistance,resultHeight);
    }
}
