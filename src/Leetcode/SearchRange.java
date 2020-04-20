package Leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        if(nums == null || nums.length == 0) return arr;
        arr[0] = findDown(nums, target);
        arr[1] = findUp(nums, target);
        return arr;
    }

    public static int findUp(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        boolean isFind = false;
        //注意为<=
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                //找上界，low++
                //当low等于high时证明此时high为上界
                low++;
                isFind = true;
            }
        }
        return isFind ? high : -1;
    }

    public static int findDown(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        boolean isFind = false;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                //找下界
                high--;
                isFind = true;
            }
        }
        return  isFind ? low : -1 ;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] res = searchRange(arr,6);
        System.out.println(res[0] + " " + res[1]);
    }
}
