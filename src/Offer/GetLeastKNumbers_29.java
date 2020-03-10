package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8 这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 解题思路：其实就是考察排序。只需要取到前面的K个元素即可
 *          大根堆,维护K个数即可。
 */
public class GetLeastKNumbers_29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k < 1 || k > input.length) return list;
        if(input == null || input.length == 0) return list;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<Integer> getLeastKNumbers(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k < 1 || k > input.length) return list;
        if(input == null || input.length == 0) return list;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new IntegerCompare());
        for (int i=0;i<input.length;i++){
            if (pq.size() < k){
                pq.add(input[i]);
            } else{
                if(pq.peek() > input[i]){
                    pq.remove();
                    pq.add(input[i]);
                }
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }

    class IntegerCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
