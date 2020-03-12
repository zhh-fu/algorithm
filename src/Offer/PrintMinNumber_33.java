package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 解题思路:就像最小字典序数组一样，不能单纯比较a 和 b的大小，要比较a+b和b+a的大小。
 *          重写Comparator同时不能对基本的int生效，所以要转化为ArrayList
 *          另外要注意string不能赋值为null
 */
public class PrintMinNumber_33 {
    public String PrintMinNumber(int [] numbers) {
        //不能为null
        if(numbers == null || numbers.length == 0) return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numbers){
            list.add(num);
        }
        Collections.sort(list,new NumberCompare());
        //不能为null
        String res = "";
        for(int i:list){
            res += i;
        }
        return res;
    }

    public class NumberCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 + "" + o2).compareTo(o2 + "" + o1);
        }
    }
}
