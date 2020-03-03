package Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 解题思路1：考虑稳定性排序的思路，如果为奇数就不动，为偶数就找到偶数后面的第一个奇数
 *          然后将偶数和奇数间所有的偶数都向后整体移动一位。
 *          时间复杂度高。
 * 解题思路2：空间换时间。
 *           创建一个新数组或者两个新数组或者队列。
 *           遍历两遍数组，第一遍将所有的奇数放入新数组中；
 *           第二遍将所有的偶数放入新数组中。
 *           然后用后来的数组覆盖原来的数组即可。
 *
 *
 */
public class ReOrderArray_13 {
    private void reOrderArray(int [] array) {
        if (array == null || array.length < 2) return;
        Queue<Integer> qNegative = new LinkedList<>();
        Queue<Integer> qNoneNegative = new LinkedList<>();
        for(int i=0;i<array.length;i++){
            if((array[i] & 1) == 1){
                qNegative.add(array[i]);
            } else{
                qNoneNegative.add(array[i]);
            }
        }
        int i = 0;
        while(!qNegative.isEmpty()){
            array[i++] = qNegative.poll();
        }
        while(!qNoneNegative.isEmpty()){
            array[i++] = qNoneNegative.poll();
        }
    }

    public void reOrderArray_1(int [] array) {
        if (array == null || array.length < 2) return;
        int k=0;  //k记录奇数的个数
        for(int i=0;i<array.length;i++){
            if(array[i] % 2 == 1){
                int j = i;
                //当 j >= k+1证明出现了偶数
                //当 j == k 的时候证明是前面的数都是奇数。
                while(j > k){
                    //注意这个地方不能使用j--，因为是作为形参传进去的，不会更改j的实际值
                    //所以必须使用j-1，然后再执行j--;
                    swap(array,j,j-1);
                    j--;
                }
                k++;
            }
        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
