package Offer;

import BasicConstructure.TreeNode;

import java.util.*;

/**
 * 二叉树中和为某一个值的路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath_24 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> listSub = new ArrayList<Integer>();

        helper(root,target,listSub,list);

        //此处是对题目要求中的注意进行排序
        Collections.sort(list, new SortCompare());
        return list;
    }

    private void helper(TreeNode root,int target,ArrayList<Integer> listSub,ArrayList<ArrayList<Integer>> list){
        if (root == null) return;
        //使target不断减小的同时将节点值放入list中
        target -= root.value;
        listSub.add(root.value);
        //和为target且为叶节点时加入到总的list中
        if (target == 0 && root.left ==null && root.right == null){
            //此处需要重新new一个，否则list中的所有元素都指向了同一个listSub
            list.add(new ArrayList<Integer>(listSub));
        }
        //类似于先序遍历
        helper(root.left,target,listSub,list);
        helper(root.right,target,listSub,list);
        //执行到这一步的时候证明当前节点下的路径已经遍历完，需要返回到它的父节点
        //需要将最后的值移去，返回到它的父节点
        listSub.remove(listSub.size() - 1);
    }

    //排序，按照list的大小进行排序，长的在前
    class SortCompare implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o2.size() - o1.size();
        }
    }

}
