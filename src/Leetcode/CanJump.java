package Leetcode;

/**
 * 跳格子问题
 * 给定一个非负整数数组，你最初位于数组的第一个位置
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) return true;
        int maxReach = nums[0];
        //这个地方不用到最后一步，倒数第二步就可以了，
        //因为如果倒数第二部还不能到达的话，那么肯定到不了最后一步
        for (int i=0;i<nums.length - 1;i++){
            //if判断很关键，限制了当前位置为0后跳不动的问题
            if (i <= maxReach){
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length - 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
