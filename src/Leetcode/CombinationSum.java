package Leetcode;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> list = new LinkedList<>();
    //自己写的，巨蠢
    public List<List<Integer>> combinationSum_1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) return list;
        List<Integer> subList = new LinkedList<>();

        helper(candidates, target, 0, subList);
        return list;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> subList) {
        if (target == 0){
            List<Integer> sList = new ArrayList<>(subList);
            list.add(sList);
            return;
        }

        if (target < 0 || index == candidates.length) return;
        List<Integer> sList1 = new ArrayList<>(subList);
        sList1.add(candidates[index]);
        helper(candidates, target - candidates[index], index,  sList1);
        helper(candidates, target, index + 1, subList);
    }

    //真正的解题套路
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        //判断
        if (candidates == null || candidates.length == 0 || target <= 0) return list;
        LinkedList<Integer> subList = new LinkedList<>();
        //排序，便于剪枝，以便于淘汰遍历不到的结果
        Arrays.sort(candidates);
        helper_2(candidates, target, 0, subList);
        return list;
    }

    private void helper_2(int[] candidates, int target, int index, LinkedList<Integer> subList){
        //判断条件，满足则添加
        if (target == 0){
            //重新引用
            list.add(new ArrayList<>(subList));
            return;
        }

        //for循环，起始下标为上一分支的减数下标
        for (int i = index;i < candidates.length;i++){
            //可以直接去重
            if (target - candidates[i] >= 0){
                //做选择
                subList.add(candidates[i]);
                //递归，注意，因为可以重复使用数字，所以下标为 i
                helper_2(candidates, target - candidates[i], i, subList);
                //撤销选择
                subList.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {8,7,4,3};
        List<List<Integer>> list = new CombinationSum().combinationSum_2(arr, 11);
        for (List<Integer> sl : list){
            System.out.println(sl);
        }
    }
}
