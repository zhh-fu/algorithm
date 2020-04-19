package Leetcode;

import java.util.List;

/**
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        char[] chs = digits.toCharArray();
        String[] strs = new String[chs.length];
        for (int i=0;i<digits.length();i++){
            strs[i] = getChar(chs[i]) ;
        }

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
}
