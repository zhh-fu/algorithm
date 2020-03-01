package Offer;

/**
 * 斐波那契数列问题
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 解题思路1：递归，效果很差
 * 解题思路2：暴力递归转dp
 */
public class Fibonacci_7 {
    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return  fibonacci(n-1) + fibonacci(n-2);
        }
    }

    private static int fibonacci1(int n) {
        int[] res = new int[n+1];
        if (n < 2){
            return n;
        } else {
            res[0] = 0;
            res[1] = 1;
            for(int i = 2;i <= n;i++){
                res[i] = res[i-1] + res[i - 2];
            }
        }

        return res[n];
    }

    public static void main(String[] args){
        for (int i = 0; i < 40;i++){
            System.out.println(Fibonacci_7.fibonacci1(i) == Fibonacci_7.fibonacci(i));
        }
    }
}
