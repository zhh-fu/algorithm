package AdvancedAlgorithm;

import java.util.HashMap;

/**
 * 给定数组arr，arr中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 再给定一个整数aim代表要找的钱数，
 * 求换钱有多少种方法。
 */
public class ChangeMoney {
    public static int changeMoney1(int[] arr,int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        return process(arr,0, aim);
    }

    /**
     * 暴力递归
     * @param arr   全局变量，代表钱的数组
     * @param index 可以使用任意index 及其之后的钱
     * @param aim   目标钱数
     * @return res  方法数
     */
    public static int process(int[] arr,int index,int aim){
        int res = 0;
        if (index == arr.length){
            //到数组的最后，如果还有余钱证明没有合适的方法
            //如果没有余钱，证明找到了一种合适方法
            res = aim == 0 ? 1 : 0;
        }

        /**
         * @param i     为使用当前钱数的张数
         * @param index 为使用当前钱数的索引值
         */
        for (int i=0;arr[index] * i <= arr.length;i++){
            res += process(arr,index + 1,aim - arr[index] * i);
        }
        return res;
    }

    /**
     * 记忆化搜索
     * 无后效性问题，不管通过什么路径到达该状态
     * 一旦index 和 aim 确定后 ，之后的方法数是确定的
     * @param arr   全局变量，存钱数组
     * @param aim   目标值，或者剩余钱数
     * @param index 可以使用任意index 及其之后的钱
     * @return
     */
    //key：  "index_aim"
    //value: 返回值
    public static HashMap<String, Integer> map = new HashMap<>();

    public static int process_map(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            //到数组的最后，如果还有余钱证明没有合适的方法
            //如果没有余钱，证明找到了一种合适方法
            res = aim == 0 ? 1 : 0;
        }
        else {
            /**
             * @param i     为使用当前钱数的张数
             * @param index 为使用当前钱数的索引值
             */
            for (int i = 0; arr[index] * i <= arr.length; i++) {
                int nextAim = aim - arr[index] * i;
                //先将下一个key计算出来
                String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);

                //有就直接拿来用
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    //没有就递归
                    res += process(arr, index + 1, nextAim);
                }
            }
        }
        //将计算结果放入map中，避免大量重复计算
        map.put(String.valueOf(index) + "_" + String.valueOf(aim),res);
        return res;
    }

    /**
     * 动态规划法
     * @param arr 全局数组
     * @param aim 目标值
     * @return process_dp(arr,0,aim);
     */
    public static int process_dp(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0 ){
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];
        //aim 为 0 的时候，方法为1
        for (int i=0;i < arr.length;i++){
            dp[i][0] = 1;
        }

        for (int j=1;j * arr[dp.length - 1] <= aim;j++){
            //最后一行
            //就是最后一种面值在每个为它倍数的位置只有一种拼法
            dp[dp.length - 1][arr[dp.length - 1] * j] = 1;
        }

        //从左下角向右上角搭积木
        for (int i=dp.length - 2;i >= 0;i--){
            for (int j = 1;j <= aim;j++){
                //当前位置等于它下一个位置加上它往前走arr[i]的位置
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[0][aim];
    }

}
