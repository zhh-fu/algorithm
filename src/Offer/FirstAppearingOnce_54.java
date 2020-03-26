package Offer;

/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 解题思路：类似之前的题
 * 1、用ASCII码值当下标，然后遍历即可
 * 2、LinkedHashMap,返回第一个键值对即可
 * 3、HashMap，通过对字符串遍历得到第一个字符
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstAppearingOnce_54 {
    private LinkedHashMap<Character,Character> map = new LinkedHashMap<>();
    private HashMap<Character,Character> hashMap = new HashMap<>();
    private StringBuffer sb = new StringBuffer();
    //ASCII码一共有256个字符
    private int[] chs = new int[256];
    //Insert one char from stringstream
    public void Insert_1(char ch){
        sb.append(ch);
        if(chs[ch] == 0){
            chs[ch] = 1;
        }else{
            chs[ch]++;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce_1(){
        char[] ch = sb.toString().toCharArray();
        for(char i : ch){
            if(chs[i] == 1){
                return i;
            }
        }
        return '#';
    }

    //Insert one char from stringstream
    public void Insert_2(char ch){
        sb.append(ch);
        if(map.containsKey(ch)){
            map.remove(ch);
        }else{
            map.put(ch,ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce_2(){
        if(!map.isEmpty()){
            //不为空时返回第一个即可
            for(Map.Entry<Character,Character> entry : map.entrySet()){
                return entry.getKey();
            }
        }
        return '#';
    }

    //Insert one char from stringstream
    public void Insert_3(char ch){
        sb.append(ch);
        if(hashMap.containsKey(ch)){
            hashMap.remove(ch);
        }else{
            hashMap.put(ch,ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce_3(){
        char[] ch = sb.toString().toCharArray();
        if(!hashMap.isEmpty()){
            //通过遍历返回第一个
            for(char i : ch){
                if(hashMap.containsKey(i)){
                    return hashMap.get(i);
                }
            }
        }
        return '#';
    }

}
