package AdvancedAlgorithm.Tree;

import BasicConstructure.Node;

public class IsBST {

    private static class ReturnInfo{
        private int height;
        private boolean isBalance;

        private ReturnInfo(int height,boolean isBalance){
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static ReturnInfo process(Node head){
        //空树也是一棵平衡树
        if (head == null){
            return new ReturnInfo(0,true);
        }

        //左树不平衡直接false
        ReturnInfo leftSubInfo = process(head.left);
        if (!leftSubInfo.isBalance){
            return new ReturnInfo(0,false);
        }

        //右树不平衡直接false
        ReturnInfo rightSubInfo = process(head.right);
        if (!rightSubInfo.isBalance){
            return new ReturnInfo(0,false);
        }

        //两树差大于1 不平衡，false
        if (Math.abs(leftSubInfo.height - rightSubInfo.height) > 1){
            return new ReturnInfo(0,false);
        }

        //左右树最大高度 + 1为当前高度
        return new ReturnInfo(
                Math.max(leftSubInfo.height,rightSubInfo.height) + 1,
                true);
    }
}
