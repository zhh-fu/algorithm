package Offer;

/**
 * 1~n整数中数字1出现的次数
 * 1~13中包含1的数字有1、10、11、12、13,因此共出现6次,
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 解题思路1：常规思路，暴力解答；
 * 解题思路2：分别求得个位，十位，百位。。。上1的个数，找规律
 *            k = n % (i * 10)
 *            i=1表示个位，i=10代表十位,i=100代表百位
 *            count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
 *            后面的算式可以优化为Math.min(Math.max(k-i+1,0),i);
 */
public class NumberOf1Between1AndN_Solution_31 {
    private static int numberOf1Between1AndN_Solution(int n) {
        if (n < 1) return 0;
        int count = 0;
        for (int i=1;i <= n;i++){
            int num = i;
            while(num != 0){
                if( num % 10 == 1){
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }

    private int numberOf1Between1AndN_Solution_2(int n) {
        if (n < 1) return 0;
        int count = 0;
        for (int i=1;i <= n;i*=10){
            int k = n % (i * 10);
            int mod = 0;
            count += (n/(i*10))*i;
            if(k > 2*i - 1){
                mod = i;
            } else if(k < i){
                mod = 0;
            } else{
                mod = k - i + 1;
            }
            count += mod;
            /*
            可优化为下面的公式
            count += (n/(i*10))*i + Math.min(Math.max(k-i+1,0),i);
             */
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(numberOf1Between1AndN_Solution(13));
    }
}
