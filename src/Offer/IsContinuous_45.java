package Offer;

/**
 * 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)
 * “红心A,黑桃3,小王,大王,方片5”,
 * 大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)
 * 现在,要求你使用这幅牌模拟上面的过程,如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 *
 * 解题思路：首先要明确：10，11，12，13，1不算顺子！！！！
 *          记录最大值和最小值，然后看他们的差值是否小于5，同时记录0的个数和出现对子的情况
 *          出现对子必不可能成立
 */

import java.util.Arrays;

public class IsContinuous_45 {
    public static boolean isContinuous_1(int [] numbers) {
        if(numbers == null || numbers.length < 5) return false;
        int numOfZero = 0;
        int numTotal = 0;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length - 1;i++){
            //遇0跳过
            if(numbers[i] == 0){
                numOfZero++;
                continue;
            }
            //对子
            if(numbers[i] == numbers[i+1]) return false;
            //等差数列的差为1，再减去1就相当于是没有差别了，如果有差别就用0去填
            //numbers[i+1] - numbers[i] - 1
            numTotal += numbers[i+1] - numbers[i] - 1;
        }
        //零的个数必须大于等于差才能填满
        if(numOfZero >= numTotal) return true;
        return false;
    }

    public static boolean isContinuous_2(int [] numbers) {
        if(numbers == null || numbers.length < 5) return false;
        //记录各个数字的个数
        int[] num = new int[14];
        int max = -1;
        int min = 14;
        for(int i=0;i<numbers.length;i++){
            num[numbers[i]]++;
            //为0直接进入下一轮
            if(numbers[i] == 0) continue;
            //数量超过1个，出现对子，false
            if(num[numbers[i]] > 1) return false;
            //记录最大值和最小值
            if(numbers[i] > max){
                max = numbers[i];
            }
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        //最大值和最小值小于5才能行
        if(max - min < 5) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {11,12,13,1,0};
        System.out.println(isContinuous_2(arr));
    }
}
