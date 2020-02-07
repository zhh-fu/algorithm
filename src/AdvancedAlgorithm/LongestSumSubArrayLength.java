package AdvancedAlgorithm;

import java.util.HashMap;

/**
 * 给定一个数组arr，和一个整数aim.
 * 求在arr中，累加和等于aim的最长子数组的长度。
 */
public class LongestSumSubArrayLength {
    public static int longestSumSubArrayLength(int[] arr,int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }
        //key 存储前 i 个数的累加和，value 存储key出现的最早的位置
        HashMap<Integer,Integer> map = new HashMap<>();
        //数组中没有数的时候可以累加出 0
        //如果没有这条记录，会错过所有的以零开头的记录
        map.put(0,-1);

        int sum = 0;
        int length = 0;
        for (int i=0;i<arr.length;i++){
            sum += arr[i];
            //查sum - aim的出现与否，求得最长长度
            if (map.containsKey(sum - aim)){
                length = Math.max(i - map.get(sum - aim),length);
            }
            //如果没有这条记录则加入
            //因为map的性质使得只存储最早出现的位置
            if (!map.containsKey(sum)){
                map.put(sum , i);
            }
        }
        return length;
    }
}
