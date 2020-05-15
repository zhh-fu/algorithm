package Leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 此题不能使用窗口法，因为k可能为负值，l要右移时不能确定
 */
public class SubarraySumEqualK {
    //暴力枚举
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int num = 0;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum += nums[j];
                if (sum == k){
                    num++;
                }
            }
        }
        return num;
    }

    //前缀加hash
    public static int subarraySum_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int num = 0;
        int pre = 0;
        //以i结尾的数组前缀和为key
        //该前缀和出现的次数为value
        HashMap<Integer, Integer> map = new HashMap<>();
        //0 值需要额外放入
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            pre += nums[i];
            /*如果遍历过程中发现，map 中已存在 key 为 当前前缀和 - k
            说明存在 【之前求出的前缀和】，它的值满足 【当前前缀和】-【之前求出的前缀和】 = k
            把 【之前求出的前缀和】 出现的次数，累加给 count 计数器
            */
            if(map.containsKey(pre - k)){
                num += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        System.out.println(subarraySum_1(arr,6));
    }
}
