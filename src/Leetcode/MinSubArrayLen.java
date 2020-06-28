package Leetcode;

/**
 * @description 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 * @author zhh_fu
 * @date 2020/6/28 22:11
 * @solution 因为限定了数组的元素全部为正，因此可以采用双指针，求区间内的和
 */

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length == 0) return 0;
        int l = 0, r = 0;
        int sum = 0, res = Integer.MAX_VALUE;
        while (r < nums.length){
            sum += nums[r];
            // 注意这个地方采用的是while循环
            // 因为可能出现r所在位置较大的情况
            while(sum >= s){
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        // 注意最后可能会发生数组的全部元素和仍小于 s 的情况
        //return res == Integer.MAX_VALUE ? 0 : res;
        return r - l == nums.length ? 0 : res;
    }
}
