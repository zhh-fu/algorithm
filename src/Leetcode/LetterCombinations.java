package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<StringBuffer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.trim().equals("")) return res;
        int index = 0;
        char[] chs = digits.toCharArray();
        while (index < chs.length && chs[index] == '1'){
            index++;
        }
        if (index == chs.length) return  res;
        String str = getChar(chs[index]);
        for (int i=0;i<str.length();i++){
            StringBuffer sb = new StringBuffer();
            sb.append(str.charAt(i));
            list.add(sb);
        }

        for (int i=index+1;i<chs.length;i++){
            if (chs[i] == '1') continue;
            String s = getChar(chs[i]);
            List<StringBuffer> subList = new ArrayList<>();

            for (StringBuffer sb : list){
                for (int j=0;j<s.length();j++) {
                    StringBuffer sb1 = new StringBuffer(sb);
                    sb1.append(s.charAt(j));
                    subList.add(sb1);
                }
            }
            list = new ArrayList<>(subList);
        }

        for (StringBuffer sb : list){
            res.add(sb.toString());
        }
        return  res;
    }

    private String getChar(char num){
        switch (num){
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombinations().letterCombinations("");
        System.out.println(list.size());
        System.out.println(list);
    }
}
