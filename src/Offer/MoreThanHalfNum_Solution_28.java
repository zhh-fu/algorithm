package Offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * 解题思路1：桶排序的思想，找到最大最小值，然后使用int[max-min+1]，因为可能存在负值
 * 解题思路2：对数组进行排序。
 *            如果存在这样一个值的话，那么它一定是数组的中位数。
 *            时间复杂度为O(nlogn)
 * 解题思路3：使用HashMap来存储数据和次数。
 * 解题思路4：如果存在这样一个数，那么它的次数要比其他元素加起来的次数还要多。
 *          解释：
 *          采用阵地攻守的思想：
 *          第一个数字作为第一个士兵，守阵地；count = 1；
 *          遇到相同元素，count++;
 *          遇到不相同元素，即为敌人，同归于尽,count--；
 *          当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 *          再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
 */
public class MoreThanHalfNum_Solution_28 {
    public int moreThanHalfNum_Solution_1(int [] array) {
        if(array == null || array.length == 0) return 0;
        //如果只有一个数直接返回即可
        if(array.length == 1) return array[0];
        int max = array[0];
        int min = array[0];
        //找到最大最小值
        for(int i=1;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        //因为可能存在负值，所以不能直接使用int[max+1]
        int[] bucket = new int[max - min+1];
        for(int i=0;i<array.length;i++){
            //让最小值占据数组的0位置，其他的数依次向后移动min个位置
            bucket[array[i] - min]++;
        }
        max = bucket[0];
        int index = 0;
        for(int i=0;i<bucket.length;i++){
            if(bucket[i] > max){
                //确定出现的最多次数和相对应的数
                max = bucket[i];
                index = i+min;
            }
        }
        //进行判断
        if(max > array.length/2){
            return index;
        } else{
            return 0;
        }
    }

    public int moreThanHalfNum_Solution_2(int [] array) {
        if(array == null || array.length == 0) return 0;
        if(array.length == 1) return array[0];
        Arrays.sort(array);
        int res = array[array.length/2];
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == res) count++;
            if(count > array.length/2) return res;
        }
        return 0;
    }

    public int moreThanHalfNum_Solution_3(int [] array) {
        if(array == null || array.length == 0) return 0;
        //如果只有一个数直接返回即可
        if(array.length == 1) return array[0];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                int count = map.get(array[i]);
                map.put(array[i],++count);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() > array.length/2){
                return entry.getKey();
            }
        }
        /*
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }
        */
        return 0;
    }

    public int moreThanHalfNum_Solution_4(int [] array) {
        if(array == null || array.length == 0) return 0;
        int index = array[0];
        int count = 1;
        for(int i=1;i<array.length;i++){
            //归零则重新赋值
            if(count == 0){
                index = array[i];
            }
            //相同++，不同--
            if(array[i] == index){
                count++;
            } else{
                count--;
            }
        }
        count = 0;
        //最后再判断一次
        for(int i=0;i<array.length;i++){
            if(array[i] == index) count++;
            if(count*2 > array.length) return index;
        }
        return 0;
    }
}
