package Offer;

import BasicConstructure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 解题思路：怎么序列化就怎么反序列化
 * 1：先序
 * 2：层序
 */
public class SerializeAndDeserialize_61 {

    //先序
    public String serialize_1(TreeNode root) {
        if(root == null) return "#!";
        String str = root.val + "!";
        str += serialize_1(root.left);
        str += serialize_1(root.right);
        return str;
    }

    public TreeNode deserialize_1(String str) {
        String[] strs = str.split("!");
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<strs.length;i++){
            q.add(strs[i]);
        }
        return helper(q);
    }

    private TreeNode helper(Queue<String> q){
        String str = q.poll();
        if(str.equals("#")) return null;
        TreeNode head = new TreeNode(Integer.parseInt(str));
        head.left = helper(q);
        head.right = helper(q);
        return head;
    }

    //层序
    public static String serialize_2(TreeNode root) {
        if(root == null) return "#!";
        String str = "";
        TreeNode head = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            head = q.poll();
            if(head == null){
                str += "#!";
            }else{
                str += head.val + "!";
                q.add(head.left);
                q.add(head.right);
            }
        }
        return str;
    }
    public static TreeNode deserialize_2(String str) {
        String[] strs = str.split("!");
        if(strs[0].equals("#")) return null;
        Queue<TreeNode> qnode = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode root = head;
        qnode.add(head);
        int i = 1;
        while (i < strs.length){
            head = qnode.poll();
            //注意此处只有当head != null的时候才有孩子，i才会往后走两位
            //因此只能使用while不能用for循环
            if (head != null){
                TreeNode left = strs[i].equals("#") ? null : new TreeNode(Integer.parseInt(strs[i]));
                TreeNode right = strs[i+1].equals("#") ? null : new TreeNode(Integer.parseInt(strs[i+1]));
                head.left = left;
                head.right = right;
                qnode.add(left);
                qnode.add(right);
                i = i + 2;
            }
        }
        return root;
    }


    private TreeNode deserialize_3(String str) {
        TreeNode head = null;
        if(str == null || str.length() == 0)
            return head;
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++){
            if(!nodes[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        for(int i=0, j=1; j<treeNodes.length; i++){
            if(treeNodes[i] != null){
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        //root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(2);
        //root.right.right = new TreeNode(7);
        String s = "5!4!#!3!#!2!#!#!#!";
        System.out.println(deserialize_2(s));
    }
}
