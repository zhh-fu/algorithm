package Offer;

/**
 * 不用加法乘除做四则运算
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddNoOperation_48 {
    public static int Add(int num1,int num2) {
        while((num2 & num1) != 0){
            /**
             *
             * 按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
             * 异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果
             * n1&n2是查看有没有进位位了，如果有，需要重复这个过程；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
             * tmp = num1 ^ num2 ，异或运算，相当于不考虑进位的加法
             * num2 = (num1 & num2) << 1 ， 与运算，并左移一位，相当于只考虑进位
             * 判断哪些位置上的数为1，这样可以进一位
             */
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        //return num1; 也可以，因为最终num2为0
        return num1 | num2;
    }

    public static void main(String[] args){
        System.out.println(Add(5,7));
    }
}
