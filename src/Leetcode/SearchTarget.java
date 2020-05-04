
package Leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchTarget {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int low = 0, high = nums.length - 1;
        int mid = (high - low) / 2 + low;
        //此处是小于等于
        while (low <= high){
            if (nums[mid] == target){
                return mid;
            }
            // 先根据 nums[mid] 与 nums[low] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[low]){
                // 再判断target是在mid的左边还是右边，从而调整左右边界low和high
                //注意此处的小于等于号
                if (nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target &&  target <= nums[high] ){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
