package Offer;

import BasicConstructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路：层序遍历，使用双栈法，可以加分层标志也可以不加
 */
public class PrintTree_59 {
    //加分层标志
    private static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        boolean flag = true;
        if(pRoot == null) return list;
        //stack1存放正序，stack2存放逆序
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode head = pRoot;
        stack1.push(head);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<Integer>();
            if(flag){
                //在一个栈里直接操作完毕
                while(!stack1.isEmpty()){
                    head = stack1.pop();
                    //正序存放，先左后右
                    if(head.left != null){
                        stack2.push(head.left);
                    }
                    if(head.right != null){
                        stack2.push(head.right);
                    }
                    System.out.print(head.val + " ");
                    subList.add(head.val);
                    if(stack1.isEmpty()){
                        list.add(subList);
                        flag = false;
                        System.out.println(" ");
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    head = stack2.pop();
                    //逆序存放，先右后左
                    if(head.right != null){
                        stack1.push(head.right);
                    }
                    if(head.left != null){
                        stack1.push(head.left);
                    }
                    System.out.print(head.val + " ");
                    subList.add(head.val);
                    if(stack2.isEmpty()){
                        list.add(subList);
                        flag = true;
                        System.out.println(" ");
                    }
                }
            }
        }
        return list;
    }

    //不加分层标志，通过栈是否为空来进行判断
    public ArrayList<ArrayList<Integer> > print_2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode head = pRoot;
        stack1.push(head);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<Integer>();
            //只有两种状态，栈1为空或者栈2为空
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    head = stack1.pop();
                    if(head.left != null){
                        stack2.push(head.left);
                    }
                    if(head.right != null){
                        stack2.push(head.right);
                    }
                    subList.add(head.val);
                    if(stack1.isEmpty()){
                        list.add(subList);
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    head = stack2.pop();
                    if(head.right != null){
                        stack1.push(head.right);
                    }
                    if(head.left != null){
                        stack1.push(head.left);
                    }
                    subList.add(head.val);
                    if(stack2.isEmpty()){
                        list.add(subList);
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> list = print(root);
        for (ArrayList<Integer> sub : list){
            for (Integer a : sub){
                System.out.print(a + " ");
            }
            System.out.println(" ");
        }
    }
}
