package Leetcode;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 */
public class NumSquares {
    public static int numSquares(int n) {
        if (n < 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n);
        dp[0] = 1;
        for (int i=0;i<=n;i++){
            if (Math.pow((int) Math.sqrt(i), 2) == i){
                dp[i] = 1;
            } else {
                for (int j=1;j*j<=i;j++){
                    //答案中的转移方程为下图，刚开始并不理解为什么是 + 1
                    //dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
                    //后来想明白了，因为dp[j*j] 必定为1，因为它是完全平方数
                    dp[i] = Math.min(dp[i], dp[i-j*j] + dp[j*j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i=0;i<15;i++){
            System.out.println(numSquares(i));
        }

    }
}
