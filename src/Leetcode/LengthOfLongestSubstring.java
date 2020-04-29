package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长不重复的子串
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals("")) return 0;
        if (s.trim().equals("")) return 1;
        int max = 1;
        char[] chs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < chs.length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return max;
    }


    public int lengthOfLongestSubstring_2(String s) {
        if(s == null || s.equals("")) return 0;
        if (s.trim().equals("")) return 1;
        int p1 = 0, p2 = 0, max = 1;
        char[] chs = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while(p1 != chs.length && p2 != chs.length){
            if(set.contains(chs[p2])){
                set.remove(chs[p1++]);
            } else {
                set.add(chs[p2++]);
                max = Math.max(max, p2 - p1);
            }
        }
        return max;
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
     * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     */
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().equals("")) return 0;
        String str = s.trim();
        int p1 = str.length() - 1;
        while(p1 >= 0 && str.charAt(p1) != (' ')){
            p1--;
        }
        return str.length() - 1 - p1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("wwakep"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(lengthOfLongestSubstring("   "));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
