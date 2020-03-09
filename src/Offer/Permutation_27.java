package Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串全排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 解题思路
 *
 * 问题转换为先固定第一个字符，求剩余字符的排列；求剩余字符排列时跟原问题一样。
 * (1) 遍历出所有可能出现在第一个位置的字符（即：依次将第一个字符同后面所有字符交换）；
 * (2) 固定第一个字符，求后面字符的排列（即：在第1步的遍历过程中，插入递归进行实现）。
 * 需要注意的几点：
 *      (1) 先确定递归结束的条件，例如本题中可设i == chs.length - 1
 *      (2) 形如 aba 或 aa 等特殊测试用例的情况，通过list来排除重复元素
 *      (3) 输出的排列可能不是按字典顺序排列的，可能导致无法完全通过测试用例，考虑返回前排序，或者递归之后取消复位操作。
 *
 * (3)交换顺序后需要进行复位，也就是回溯，因为递归使用的是同一个char[] ，如果不复位会漏掉情况
 */
public class Permutation_27 {
    public ArrayList<String> Permutation(String str) {
        char[] chs = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        helper(chs, 0, list);
        //不是字典序，无法通过测试用例
        Collections.sort(list);
        return list;
    }

    private void helper(char[] chs, int i, ArrayList<String> list){
        //遍历到了末尾
        if(i == chs.length - 1){
            String str = String.valueOf(chs);
            //如果有重复的字母的话，可能会出现一样的排列
            //这个可以去除重复的情况
            if(!list.contains(str)){
                list.add(str);
            }
        } else{
            for(int j = i;j < chs.length;j++){
                //选择一个数，固定一个位置
                swap(chs,i,j);
                //后续的字母进行全排列
                helper(chs,i+1,list);
                //回溯原状态，交换回来
                swap(chs,i,j);
            }
        }
    }

    private void swap(char[] chs,int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
