package Offer;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 解题思路1：最笨的，遍历或者双指针。复杂度O(N)
 * 解题思路2：稍微优化，遍历过程中只要后面比前面小那一定是最小的。
 * 解题思路3：二分法判断，复杂度为O(logn)
 */
public class MinNumberInRotateArray_6 {
    private int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int p1 = 0;
        int p2 = array.length - 1;
        while(p1 != p2){
            if(array[p1] >= array[p2]){
                p1++;
            }else{
                p2--;
            }
        }
        return array[p1];
    }

    private static int minNumberInRotateArray1(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        //注意这个地方是 i < array.length - 1 而不是 array.length - 2
        for(int i = 0;i < array.length - 1;i++){
            if(array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArray2(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        //注意不等于和小于两种条件，不等于可能会出现重复计算情况
        while (low < high) {
            if (array[low] < array[high]) return array[low];
            int mid = low + (high - low) / 2;
            //左半部分有序
            if (array[low] < array[mid]) {
                low = mid + 1;
                //右半部分有序
            } else if (array[mid] < array[high]) {
                high = mid;
                //左中右相等
            } else {
                low++;
            }
        }
        return array[low];
    }

    public static void main(String[] args){
        int[] num = {2,3,3,4,5};

        System.out.println(MinNumberInRotateArray_6.minNumberInRotateArray1(num));

    }
}
