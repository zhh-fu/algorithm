package Offer;

/**
 * 矩形覆盖问题
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 解题思路：target为大矩形的长。
 *          如果我们在第一个格子竖着放一个小矩形，那么剩余的长度为target-1，问题转化为了求target-1的方法；
 *          如果我们在第一个格子横着放一个小矩形，那么只能在它下面横着再放一个小矩形，
 *          问题转化成了求target-2的方法数。
 *          basecase：当target为0时没有方法；target为1时只有一种方法；当target为2时，有两种方法；
 *          综合来说就是if(target > -1 && target < 3) return target;
 * 可知问题的解答当方法是递归/动态规划;两者相互转化。
 */
public class RectCover_10 {
    private static int rectCover(int target) {
        //注意此处的target的范围要大于等于0，不然会出现越界问题
        if(target > -1 && target < 3) return target;
        int sum = 0;
        return sum += rectCover(target - 1) + rectCover(target - 2);
    }

    private int rectCover1(int target) {
        int[] num = new int[target+1];
        if(target > -1 && target < 3){
            return target;
        } else{
            num[0] = 0;
            num[1] = 1;
            num[2] = 2;
            for(int i=3;i<=target;i++){
                num[i] = num[i-1] + num[i-2];
            }
            return num[target];
        }
    }

    public static void main(String[] args){
        for (int i=0;i<30;i++){
            System.out.println(rectCover(i));
        }

    }
}
