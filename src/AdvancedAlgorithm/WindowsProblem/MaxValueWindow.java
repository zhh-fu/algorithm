package AdvancedAlgorithm.WindowsProblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 得到最大值窗口
 */
public class MaxValueWindow {

    //w为窗口长度
    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }

        //双端队列，存储最大值的下标
        //LinkedList<Integer> qmax = new LinkedList<Integer>();
        Deque<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i=0;i < arr.length;i++){
            //当队列末尾代表的值小于当前值时弹出
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                 qmax.pollFirst();
            }
            qmax.addLast(i);
            //失效，弹出
            if (qmax.peekFirst() == i -w){
                qmax.pollFirst();
            }
            //最大值总等于队头代表的值
            if (i >= w - 1){
                res[i++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
