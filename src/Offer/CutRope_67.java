package Offer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 *
 * 解题思路：1、找数学规律，当绳子小于4的时候，为target - 1
 *          当绳子长度大于等于4的时候，s1*s2的积一定大于s1+s2的和，
 *          因此当target大于4的时候一定分成两份，同时单位长度为3时乘积最大，因为2*2*2<3*3
 *          因此只需要判断里面有多少个3即可，在不够3时退一个3，因为2*2>3*1
 * 解题思路2：dp。dp[i]代表当剩余绳子长度为i时的最优解，
 *               dp[i] = 最少切一刀的最优解; 最少切一刀或者不切的最优解
 *               并不一定是非要切一刀，因此dp[i] = i(i < 4)
 */
public class CutRope_67 {
    public static int cutRope_1(int target) {
        if (target <= 1) return 0;
        if (target < 4) return target -1 ;
        int num = target / 3;
        int mod = target % 3;
        if (mod == 0){
            return (int) Math.pow(3,num);
        } else if (mod == 1){
            return (int) Math.pow(3,num-1)*4;
        } else {
            return (int) Math.pow(3,num)*2;
        }
    }

    public static int cutRope_2(int target) {
        if (target <= 1) return 0;
        if(target < 4) return target - 1;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i=4;i<=target;i++){
            int max = 0;
            //i的一半的原因是，当和一定的两个数相等时乘积最大
            //如果超过了i/2相当于重复计算
            for (int j=1;j<=i/2;j++){
                max = Math.max(max, dp[j] * dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(cutRope_2(4));
    }
}
