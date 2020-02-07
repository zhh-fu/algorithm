package AdvancedAlgorithm;

/**
 * 最长子数组问题
 * 全都是正数
 */
public class LongestSubArrayInPositiveArray {
    public static int longestSubArray(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }

        int L = 0,R = 0;
        int sum = arr[0];
        int length = 0;

        while (R < arr.length){
            if (sum == aim){
                //相等则取较大值，L右移
                length = Math.max(length,R - L + 1);
                //先用再加
                sum -= arr[L++];
            }
            else if (sum < aim){
                R++;
                //R++ 可能会溢出
                if (R == arr.length){
                    break;
                }
                sum += arr[R];
            }
            else {
                //sum > aim ，溢出，L右移
                sum -= arr[L++];
            }
        }
        return length;
    }
}
