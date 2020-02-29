package Offer;
import java.util.HashSet;

/*
数组中的重复数字
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

解题思路1：利用Hash，set或者map均可。
解题思路2：占位。因为数组中的数在0-n-1之间，如果相应位置被占，即证明存在重复数。
解题思路3：原地置换法
*/
public class DuplicateNumInArray {
    /**
     *
     * @param numbers an array of integers
     * @param length  the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
     * @return true if the input is valid, and there are some duplications in the array number
     *         otherwise false
     */
    //hash法
    private static boolean duplicate1(int numbers[], int length, int [] duplication) {
        if(numbers == null || length < 2){
            return false;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        while(i < length){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            else{
                set.add(numbers[i++]);
            }
        }
        return false;
    }

    //占位法
    private static boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null || length < 2){
            return false;
        }
        boolean[] k = new boolean[length];
        int i = 0;
        while(i < length){
            if(k[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }
            else{
                k[numbers[i++]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] num = {2,1,3,1,4};
        int[] duplication = new int[1];
        System.out.println(DuplicateNumInArray.duplicate1(num,5,duplication));
        System.out.println(DuplicateNumInArray.duplicate2(num,5,duplication));
    }
}
