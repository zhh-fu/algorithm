package AdvancedAlgorithm.WindowsProblem;

import java.util.LinkedList;

/**
 * 找到子数组的最大值和最小值的差小于等于aim的子数组的数量
 */
public class AllLessNumSubArray {

    public static int getNum(int[] arr, int aim){
        if (arr == null || arr.length == 0){
            return 0;
        }

        //最大值和最小值下标更新队列
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        LinkedList<Integer> qmin = new LinkedList<Integer>();

        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length){
            while (R < arr.length) {
                //当右边界到R时，更新当前最大值
                if (!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                //当右边界到R时，更新当前最小值
                if (!qmin.isEmpty() && arr[qmin.peekFirst()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                //不达标
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > aim) {
                    break;
                }
                R++;
            }

            //判断下标过期
            //防止最小值队列的对头一直是窗口内最小
            //防止最大值队列的对头一直是窗口内最大
            if (qmin.peekFirst() == L){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == R){
                qmax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }
}
