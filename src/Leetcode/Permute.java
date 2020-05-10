package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    public List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return list;
        helper(nums,0);
        return list;
    }

    private void helper(int[] nums, int index) {
        if (index == nums.length){
            List<Integer> subList = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                subList.add(nums[i]);
            }
            if (!list.contains(subList)){
                list.add(subList);
            }
        }
        for (int i=index;i<nums.length;i++){
            swap(nums,i,index);
            helper(nums,index+1);
            swap(nums,i,index);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new Permute().permute(arr));
    }
}
