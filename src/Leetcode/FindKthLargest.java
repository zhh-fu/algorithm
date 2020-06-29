package Leetcode;

import java.util.PriorityQueue;

/**
 * @author zhh_fu
 * @description
 * @date 2020/6/29 21:18
 * @solution 小根堆/快排/基于快排思想的partition
 */

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest_1(int[] nums, int k){
        if(nums == null || nums.length == 0 || k <= 0){
            return 0;
        }
        process(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void process(int[] nums, int L, int R){
        if (L < R){
            int pivot = (int) Math.random() * (R - L + 1);
            swap(nums, R, L + pivot);
            int[] equal = new int[2];
            equal = partition(nums, L, R);
            process(nums, L, equal[0] - 1);
            process(nums, equal[1] + 1, R);
        }
    }

    private int[] partition(int[] nums, int l, int r) {
        int less = l - 1, more = r;
        int cur = l;
        while(cur < more){
            if (nums[cur] < nums[r]){
                swap(nums, cur++, ++less);
            } else if (nums[cur] > nums[r]){
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest_2(int[] nums, int k){
        if(nums == null || nums.length == 0 || k <= 0){
            return 0;
        }
        //第k大的元素的索引在排序后的数组中就是nums.length - k
        int l = 0, r = nums.length - 1, target = nums.length - k;

        while (true){
            //index为中枢的索引，index左边的元素都比它小，右边的元素都大于等于它
            int index = partition_1(nums, l, r);
            //类似二分的思想
            if (index == target){
                return nums[index];
            } else if (index < target){
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
    }

    private int partition_1(int[] nums, int l, int r) {
        int pivot = nums[l];
        int j = l;
        for (int i = l + 1;i <= r;i++){
            if (nums[i] < pivot){
                swap(nums, i, ++j);
            }
        }
        //将中枢和当前的边界交换
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,65,3,67,2,6,3,5,2};
        System.out.println(new FindKthLargest().findKthLargest_2(arr, 2));
    }
}
