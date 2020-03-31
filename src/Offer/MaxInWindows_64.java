package Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 解题思路：使用双端队列，存储数组的下标
 * 当队列尾部的下标代表的值小于当前值的话，一直弹出，直到大于
 * 当当前下标大于size-1，窗口成型，开始添加
 * 当队伍开头的下标等于当前下标i+1-size时，在下一个窗口过期，弹出。
 */
public class MaxInWindows_64 {
    //原代码，很蠢
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || size < 1) return list;
        Deque<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            if(q.isEmpty() || num[q.peekLast()] >= num[i]){
                q.add(i);
            } else{
                while(!q.isEmpty() && num[q.peekLast()] < num[i] ){
                    q.pollLast();
                }
                q.add(i);
            }

            if(i < size){
                if(num[i] > max){
                    max = num[i];
                }
                if (i == size - 1){
                    list.add(max);
                }
            } else{
                list.add(num[q.peekFirst()]);
            }

            if (q.peekFirst() == i + 1 - size){
                q.pollFirst();
            }
        }
        return list;
    }

    //优化后代码
    public ArrayList<Integer> maxInWindows_1(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || size < 1) return list;
        Deque<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            while(!q.isEmpty() && num[q.peekLast()] < num[i] ){
                q.pollLast();
            }
            q.add(i);
            if(i >= size - 1){
                list.add(num[q.peekFirst()]);
            }
            if (q.peekFirst() == i + 1 - size){
                q.pollFirst();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {16,14,12,10,8,6,4};
        System.out.println(maxInWindows(arr,5));
    }
}

