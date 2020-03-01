package Offer;

/**
 * 经典问题：青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 青蛙在到达第n级台阶有两种情况，从n-1级到达和从n-2级到达，
 * 那么方法数就是到达n-1级的方法数加上到达n-2级的方法数。
 * 也就是   f(n) = f(n-1) + f(n-2)
 * 解题思路1：递归
 * 解题思路2：暴力递归转dp
 */
public class JumpFloor_8 {
    private int jumpFloor(int target) {
        int[] num = new int[target + 1];
        if (target < 3){
            return target;
        } else{
            num[0] = 0;
            num[1] = 1;
            num[2] = 2;
            for (int i = 3;i <= target;i++){
                num[i] = num[i-1] + num[i-2];
            }
            return num[target];
        }
    }

    private int jumpFloor1(int target) {
        if (target < 3){
            return target;
        } else{
            return jumpFloor1(target - 1) + jumpFloor1(target - 2);
        }
    }
}
