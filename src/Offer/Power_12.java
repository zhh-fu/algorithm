package Offer;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 解题思路：调用库函数；分区间讨论；递归
 *          x^n = (x*x)^(n/2) when n%2 = 0;
 *          x^n = x*(x*x)^(n/2) when n%2 = 1
 *
 * 解题思路2：用指数的二进制表示来做
 *      举例:10^1101 = 10^0001*10^0100*10^1000。
 *      通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 *      每移一位，base就要翻一番，这是关键。最终结果就是所有为1的位置上的值相乘得到。
 */
public class Power_12 {
    private static double power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        //判断指数的正负，如果为负取倒数即可
        boolean isNegative = false;
        if (exponent < 0){
            exponent = -exponent;
            isNegative = true;
        }
        double power = power(base * base, exponent/2);
        //指数为奇数
        if (exponent % 2 == 1){
            power = base * power;
        }
        return isNegative ? 1/power : power;
    }

    private static double power_1(int base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double cur = 1.0;
        boolean isNegative = false;
        if (exponent < 0){
            exponent = -exponent;
            isNegative = true;
        }
        while(exponent != 0){
            if((exponent & 1) == 1){
                cur *= base;
            }
            base *= base;
            exponent = exponent>>1;
        }
        return isNegative ? 1.0/cur : cur;
    }


    public static void main(String[] args){
        System.out.println(power_1(2,-3));
    }
}
