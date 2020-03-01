package Offer;

/**
 * 青蛙跳台阶进阶版
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 解题思路：可以跳一个n-1级和1级，也可以跳n-2级和2级，也可以跳n-3级和3级....也可以跳n级
 *          分别对应f(n-1)种解法，f(n-2)种解法，f(n-3)种解法,...,1种解法
 *          那么f(n) = f(n-1) + f(n-2) + f(n-3) + ... + 1;
 * 思路1：暴力递归
 * 思路2：按照上述思路来，贪心加动态规划
 * 思路3：发现第n项的等于前n-1项的和，那么n-1项等于前n-2项的和，
 *          那么f(n) = 2*f(n-1) = 2*2*f(n-2) = ... = (2^(n-1))*f(n-(n-1)) = 2^(n-1);
 */
public class JumpFloorII_9 {
    private static int JumpFloorII(int target) {
        if(target < 3){
            return target;
        } else{
            int[] num = new int[target+1];
            num[0] = 0;
            num[1] = 1;
            num[2] = 2;
            for(int i = 3;i <= target;i++){
                int j = i;
                int sum = 1;
                while(j != 0){
                    sum += num[--j];
                }
                num[i] = sum;
            }
            return num[target];
        }
    }

    private static int JumpFloorII1(int target) {
        int sum = 0;
        if (target < 3) {
            return target;
        } else {
            while (target != 0) {
                sum += JumpFloorII1(--target);
            }
            return sum + 1;
        }

    }

    private static int JumpFloorII2(int target) {
        return (int) Math.pow(2,target-1);
        //return 1 << (target-1);
    }


}
