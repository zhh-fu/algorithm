package AdvancedAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司关系是一棵二叉树，求公司的最大活跃度。
 */
public class MaxHappyInCompany {

    private static class Node{
        private int happy;
        //公司结构为一棵多叉树，下级节点使用链表表示
        private List<Node> nexts;

        public Node(int happy){
            this.happy = happy;
            nexts = new ArrayList<>();
        }
    }

    private static class ReturnInfo{
        //只需要收集当前节点来或者不来时对应的活跃度
        private int yes_happy;
        private int no_happy;

        public ReturnInfo(int yes_happy,int no_happy){
            this.yes_happy = yes_happy;
            this.no_happy = no_happy;
        }
    }

    public static ReturnInfo process(Node head){
        //当前节点来的活跃度就是当前节点值
        int yes_hanppy = head.happy;
        int no_happy = 0;

        //此处递归的终止条件包含在for循环中
        //如果没有下级节点，返回当前节点的信息
        for (int i=0;i<head.nexts.size();i++){
            Node next = head.nexts.get(i);
            ReturnInfo nextData = process(next);

            //当前节点来，用当前节点活跃度加上下级节点不来的活跃度
            yes_hanppy = yes_hanppy + nextData.no_happy;
            //当前节点不来，取当前节点的下级节点来或者不来的最大活跃度
            no_happy = no_happy + Math.max(nextData.no_happy,nextData.yes_happy);
        }
        return new ReturnInfo(yes_hanppy,no_happy);
    }
}
