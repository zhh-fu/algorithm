package Offer;


import java.util.LinkedHashMap;

/**
 * 第一次只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar_34 {
    //法一：使用插入有序的LinkedHashMap来存储数据
    //因为HashMap的底层是散列表，输入和输出是不相关的，所以不能使用hashMap
    //而LinkedHashMap底层使用了双向链表，使得内部的数据顺序是按照put进去的顺序排列的
    public int firstNotRepeatingChar_1(String str) {
        if(str == null) return -1;
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] chs = str.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(map.containsKey(chs[i])){
                int times = map.get(chs[i]);
                map.put(chs[i],++times);
            } else{
                map.put(chs[i],1);
            }
        }

        for(int i=0;i<chs.length;i++){
            if(map.get(chs[i]) == 1){
                return i;
            }
        }

        return -1;
    }

    /*
    法二：使用字符的ASCII码来充当字母的索引
    注意：字符串中全是字母，没有数字！
     */
    public int firstNotRepeatingChar_2(String str) {
        if(str == null) return -1;
        //因为A-Z是65到90，a-z是97-122,中间一共是58个数
        int[] word = new int[58];
        char[] chs = str.toCharArray();

        //ASCII码 - 65 就是相对于A的位置，也就是字母的索引
        for(int i=0;i<chs.length;i++){
            word[(int) chs[i] - 65]++;
        }

        //当前位置为1时，证明只出现了一次
        for(int i=0;i<chs.length;i++){
            if(word[(int) chs[i] - 65] == 1){
                //此处第一次满足条件时，即为第一次，直接返回，不往下执行
                return i;
            }
        }

        return -1;
    }
}
