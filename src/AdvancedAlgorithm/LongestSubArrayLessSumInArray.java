package AdvancedAlgorithm;

/**
 * 最长子数组问题
 * 小于等于aim，数组中有正有负有零
 */
public class LongestSubArrayLessSumInArray {
    public static int maxLength(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }

        //存储从 i 位置开始的最小累加和
        //从 i 位置取得最小累加和的右边界
        int[] sum = new int[arr.length];
        int[] sum_index = new int[arr.length];

        //最后一个数就是它本身
        sum[arr.length - 1] = arr[arr.length - 1];
        sum_index[arr.length - 1] = arr.length - 1;

        for (int i = arr.length - 2;i >= 0;i--){
            //当前数 和 当前数加上前一个值的和 的较小值
            sum[i] = Math.min(arr[i],sum[i+1] + arr[i]);
            //右边界为 i 或者 sum_index[i+1]
            sum_index[i] = sum[i] == arr[i] ? i : sum_index[i+1];
        }

        /**
         * @param sumArray 从 i 到 R 的数组和
         * @param R        为最小子数组的右边界+1,即下一部分的开头
         * @param length   为最小子数组的长度
         */
        int sumArray = 0;
        int R = 0;
        int length = 0;
        //开始遍历最小和数组 sum[]
        for (int i = 0;i < arr.length;i++){
            //R不越界且 sum的值小于等于aim
            while (R < arr.length && sumArray + sum[R] <= aim){
                sumArray += sum[R];
                //计算下一段
                R = sum_index[i] + 1;
            }
            //如果 i 小于 当前右边界，证明仍在原长度中
            //否则敞口内没有东西 ，R = 0；
            sumArray -= R > i ? arr[i] : 0;
            //此处不加1是因为R在while循环中已经加过1了
            length = Math.max(length, R - i);
            //正常情况下 R 要大于 i，即右边界要大于左边界
            //如果 一开始就大于 aim，R不会右移，但是左边界右移了
            //因此 R 要往右移
            R = Math.max(R, i + 1);
        }
        return length;
    }

    public static void main(String[] args){
        int[] arr = {100,200,7,-6,-3,200};
        System.out.println(maxLength(arr,7));
    }
}
