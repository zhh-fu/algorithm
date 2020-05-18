package Leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积.
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {
    /*
    第一想法是想到dp[i] = Math.max(dp[i-1]*nums[i], nums[i]);
    但是上面的结果是不对的，因为数组中元素可能为负值，但是如果出现负负得正则出现错误
    所以如果当前位置为负，则希望以前一个位置结尾的子数组尽可能的负得大
    所以，我们要维护两个数组，分别是以当前位置结尾的子数组的最大值和最小值
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int Max = nums[0];
        for(int i=1;i<nums.length;i++){
            max[i] = Math.max(max[i-1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i-1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
            Max = Math.max(Max,max[i]);
        }
        return Max;
    }


    /*
    解法类似于1，但是只用一个常量来维护前一个值
     */
    public int maxProduct_1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0];
        int Max = nums[0];

        for(int i=1;i<nums.length;i++){
            //此处需要额外存储两个值
            //因为下面在更新时所记录的前一个值会发生变化，变为当前的最大值，影响当前最小值计算
            int maxF = max, minF = min;
            max = Math.max(maxF * nums[i], Math.max(minF * nums[i], nums[i]));
            min = Math.min(maxF * nums[i], Math.min(minF * nums[i], nums[i]));
            Max = Math.max(Max,max);
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-3,-2};
        System.out.println(new MaxProduct().maxProduct_1(arr));
    }
}
