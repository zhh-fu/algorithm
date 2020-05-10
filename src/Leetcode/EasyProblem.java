package Leetcode;

public class EasyProblem {
    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        if(x < 0 || y < 0) return 0;
        int xor = x ^ y;
        int res = 0;
        /*
        while(xor != 0){
            if((xor & 1) == 1){
                res++;
            }
            xor = xor >> 1;
        }
        */
        while (xor != 0){
            res++;
            //最右边的1会被移除
            xor = xor & (xor - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
