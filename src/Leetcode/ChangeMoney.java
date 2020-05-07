package Leetcode;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 法一：递归，要当前值和不要当前值，会超出时间
 * 法二：dp，根据递归得来
 */
public class ChangeMoney {
    public int totalNum = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) return -1;
        Arrays.sort(coins);
        helper(coins,amount,0,0);
        if (totalNum != Integer.MAX_VALUE){
            return totalNum;
        }
        return -1;
    }

    public int coinChange_1(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        //dp[i]代表取到 i 元所需的最小硬币数
        int[] dp = new int[amount + 1];
        //填充，因为全部为硬币1 也只有amount个，所以amoun+1是取不到的
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        //第一层循环是取到的钱数
        for(int i=1;i<dp.length;i++){
            //第二层循环是硬币的面值
            for(int j=0;j<coins.length;j++){
                //注意此处的判断
                if (i - coins[j] >= 0){
                    //当前所需的最少硬币数量分为两种
                    //第一种，不要当前硬币，那么它是 dp[i] 个硬币
                    //第二种，要当前的硬币，那么它是 dp[i - coins[j]] + 1 个
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public void helper(int[] coins, int amount, int i, int num){
        if (amount == 0){
            totalNum = Math.min(totalNum, num);
            return;
        }
        //溢出条件
        if ((i == coins.length && amount != 0) || amount < 0){
            return;
        }
        //不要当前的硬币， i 变化， + 1
        helper(coins, amount, i + 1, num);
        //要当前的硬币，i 不变
        helper(coins, amount - coins[i], i, num + 1);
    }

    public static void main(String[] args) {
        ChangeMoney cm = new ChangeMoney();
        int[] coins = {1,2,5};
        System.out.println(cm.coinChange_1(coins,3));
    }
}
