package Leetcode;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //dp[i] 代表以 下标i 结尾的子数组的最长子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] = dp[i] + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,3};
        System.out.println(lengthOfLIS(arr));
    }
}
