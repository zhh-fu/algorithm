package Offer;

import java.util.ArrayList;

/**
 * 和为sum的两个数
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 解题思路：双指针，首尾夹逼，
 *          需要注意，数组为排序过的，那么第一个加入的数字对必定是积最小的
 */
public class FindNumbersWithSum_42 {
    //完全按照题意来的
    public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length < 2) return list;
        int max = Integer.MAX_VALUE;
        int p1 = 0,p2 = array.length - 1,res1 = 0,res2 = 1;
        while(array[p1] <= sum/2 && p1 < p2){
            if(array[p1] + array[p2] == sum){
                if(max > array[p1] * array[p2]){
                    res1 = array[p1];
                    res2 = array[p2];
                }
                p1++;
            }else if(array[p1] + array[p2] < sum){
                p1++;
            } else{
                p2--;
            }
        }
        list.add(res1);
        list.add(res2);
        return list;
    }

    public static ArrayList<Integer> findNumbersWithSum_2(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length < 2) return list;
        int p1 = 0,p2 = array.length - 1;
        while(p1 < p2){
            if(array[p1] + array[p2] == sum){
                list.add(array[p1]);
                list.add(array[p2]);
                break;
            }else if(array[p1] + array[p2] < sum){
                p1++;
            } else{
                p2--;
            }
        }
        return list;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4,7,11,15};
        System.out.println(findNumbersWithSum(arr,15));
    }
}
