package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    //为什么要用int[][]，用list不好吗？
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        if(target <= 0) return list.toArray(new int[0][]);
        int l = 1,r = 1, sum = 1;
        while(r <= (target + 1)/2){
            if(sum == target){
                int index = l;
                int[] num = new int[r - l + 1];
                while(index <= r){
                    num[index - l] = index;
                    index++;
                }
                list.add(num);
                sum -= l;
                l++;
            } else if(sum < target){
                r++;
                sum = sum + r;
            } else {
                sum = sum - l;
                l++;
            }
        }
        return list.toArray(new int[0][]);
    }
}
