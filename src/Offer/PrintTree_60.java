package Offer;

import BasicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 解题思路：BFS，记录当前遍历的数量和当前层的总数量
 * 1、使用双队列记录值
 * 2、使用一个队列，但是要考虑list的引用
 * 3、递归，先序遍历，通过深度来判断添加节点
 */
public class PrintTree_60 {
    //双队列存储节点
    private static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return list;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode head = pRoot;
        q1.add(head);
        q2.add(head);
        int curNum = 0,nextCount = 1;
        while(!q1.isEmpty()){
            head = q1.poll();
            curNum++;
            if(head.left != null){
                q1.add(head.left);
                q2.add(head.left);
            }
            if(head.right != null){
                q1.add(head.right);
                q2.add(head.right);
            }
            if(curNum == nextCount){
                //弹出curNum个值
                ArrayList<Integer> subList = new ArrayList<Integer>();
                while(curNum != 0){
                    subList.add(q2.poll().val);
                    curNum--;
                }
                nextCount = q1.size();
                list.add(subList);
            }
        }
        return list;
    }

    private static ArrayList<ArrayList<Integer>> print_2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> subList = new ArrayList<Integer>();
        TreeNode head = pRoot;
        queue.add(head);

        int curNum = 0,nextCount = 1;
        while(!queue.isEmpty()){
            head = queue.poll();
            subList.add(head.val);
            curNum++;
            if(head.left != null){
                queue.add(head.left);
            }
            if(head.right != null){
                queue.add(head.right);
            }
            if(curNum == nextCount){
                //注意此处的构造方法，如果使用同一个subList，需要重新构建
                //不然所有的list将会指向同一个
                ArrayList<Integer> sList = new ArrayList<>(subList);
                nextCount = queue.size();
                curNum = 0;
                list.add(sList);
                //执行此行代码后list会被清空，相应的引用也会被清空
                subList.clear();
            }
        }
        return list;
    }

    private static ArrayList<ArrayList<Integer>> print_3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        helper(pRoot, 1, list);
        return list;
    }

    private static void helper(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list){
        if (root == null) return;
        //每一层一个list
        if (depth > list.size()) list.add(new ArrayList<>());
        //当前节点的值
        list.get(depth - 1).add(root.val);

        helper(root.left,depth+1, list);
        helper(root.right, depth+1, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> list = print_3(root);
        for (ArrayList<Integer> sub : list){
            for (Integer a : sub){
                System.out.print(a + " ");
            }
            System.out.println(" ");
        }
    }
}
