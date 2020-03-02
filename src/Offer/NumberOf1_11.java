package Offer;

/**
 * 二进制中一的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 解题思路1：使用内置函数直接转换为二进制数组Integer.toBinaryString(n).toCharArray();然后记数即可。
 * 解题思路2：让1去和n进行&操作，这样直接使用的是n的二进制形式。如果结果不为0，则代表相应的位置上为1；否则全部为0
 *          然后让1左移，后面其实就不是1了，“1”中只有一位是1，其他都是0.
 * 解题思路3：类似于思路2 ，让n与1进行&操作，末尾如果为1则等于1，count++；然后n无符号右移>>>即可。
 *                  使用>>可能陷入死循环，因为存在负值。
 *                  有符号右移 >> 会给负数补码高位补1，无符号右移 >>> 给负数补码高位补0。
 *  解题思路4： n = n & (n-1)
 *          把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
 *          那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
 */
public class NumberOf1_11 {

    private static int numberOf1_1(int n){
        int count = 0;
        char[] chs = Integer.toBinaryString(n).toCharArray();
        for (int i=0;i<chs.length;i++){
            if (chs[i] == '1'){
                count++;
            }
        }
        return count;
    }

    public static int numberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    private static int numberOf1_3(int n){
        int count = 0;
        while (n != 0){
            if ((n & 1) == 1){
                count++;
            }
            //有符号右移 >> 会给负数补码高位补1，无符号右移 >>> 给负数补码高位补0。
            //对于正数则无区别。
            n = n >>> 1;
        }
        return count;
    }

    /**
     *
     * 如果一个整数不为0，那么这个整数至少有一位是1。
     * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
     * 其余所有位将不会受到影响。
     */
    private static int numberOf1_4(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(numberOf1_1(-15));
    }
}
