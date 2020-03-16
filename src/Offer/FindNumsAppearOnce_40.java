package Offer;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 *
 * 解题思路1：使用set来去除重复元素，再使用Iterator迭代器来获取元素；
 * 解题思路2：桶排序，其实是有问题的，因为只考虑了正数，但是还是通过了OJ
 * 解题思路3：异或运算
 *
 * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
 * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，
 * 因为成对儿出现的都抵消了。
 *
 * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
 * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，
 * 这个结果的二进制中的1，表现的是A和B的不同的位。
 * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
 * 分组标准是第3位是否为1。
 * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
 * 然后把这两个组按照最开始的思路，依次异或，
 * 剩余的两个结果就是这两个只出现一次的数字。
 *
 */
public class FindNumsAppearOnce_40 {
    //hashset去重
    public void findNumsAppearOnce_1(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            num1[0] = 0;
            num2[0] = 0;
        }
        HashSet<Integer> set = new HashSet<>();
        //使用set去重
        for(int i=0;i<array.length;i++){
            if(set.contains(array[i])){
                set.remove(array[i]);
            } else{
                set.add(array[i]);
            }
        }
        int[] num = new int[2];
        int i = 0;
        //迭代器获取set中的元素
        Iterator it = set.iterator();
        while (it.hasNext()){
            num[i++] = (int) it.next();
        }
        num1[0] = num[0];
        num2[0] = num[1];
    }

    public void findNumsAppearOnce_2(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            num1[0] = 0;
            num2[0] = 0;
        }
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        int[] num = new int[max + 1];
        for(int i=0;i<array.length;i++){
            num[array[i]]++;
        }
        int[] res = new int[2];
        int j = 0;
        //此处索引就是真实值，只出现一次即可
        for(int i=0;i<num.length;i++){
            if(num[i] == 1){
                res[j++] = i;
            }
        }
        num1[0] = res[0];
        num2[0] = res[1];
    }

    public void findNumsAppearOnce_3(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            num1[0] = 0;
            num2[0] = 0;
        }
        int res = 0;
        //相同的 数相互抵消
        //res必定是不相同的那两个单独数的异或
        for(int i=0;i<array.length;i++){
            res ^= array[i];
        }

        //它们两个数的二进制必定至少有一位不同，找到不同的那个位
        int index = getFirstIndex(res);

        //所有的数index位要么为1，要么为0
        //相同的数的index位必定相同，异或之后必定为0
        //那么将所有的数分为两组，
        for(int i=0;i<array.length;i++){
            //将index位为1的数的异或值赋给num1
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
                //将index位为0的数的异或值赋给num2
            } else{
                num2[0] ^= array[i];
            }
        }

    }

    private int getFirstIndex(int res){
        int index = 0;
        //找到二进制为1的最低位
        while(index <= 32 && ((res & 1) == 0)){
            res >>= 1;
            index++;
        }
        return index;
    }

    //判断index位是否为1
    private boolean isBit1(int num,int index){
        return ((num >> index) & 1) == 1;
    }


}
