package Offer;

/**
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 解题思路：看 str 从 i 位置到最后是否能被 exp 从 j 位置到 最后匹配。
 * 对exp的 j+1位置来说，有三种可能性。
 * 1）有字符，不是 * ，此时 str[i] 必须和 exp[j]必须匹配，相同或者为 '.'，否则必然不匹配
 * 2）为'*'，str[i]不等于exp[j] ，此时让 exp[j]* 变为0个，然后让exp[j+2]开始和str[i]匹配。
 * 3）为'*'，str[i]等于exp[j] 。如果出现str为 aaaab的情况，尝试让'a*'依次变为 0、1、2、3 、4个a并通过exp[j+2]来进行匹配，
 * 即 process(i,j+2)，process(i+1,j+2)， process(i+2,j+2) ，process(i+3,j+2) ，如果均不可以，那么匹配失败，返回false。
 */
public class RegularExpressionMatch_52 {
    public boolean match(char[] str, char[] pattern)
    {
        /*
        if (str == null && pattern == null)
            return true;
        if (str == null && pattern != null)
            return false;
        */
        if (str == null || pattern == null) {
            return false;
        }
        /*
        只要pattern是空的，比不可能成立
        if (pattern == null) {
            return false;
        }
         */
        return helper(str,pattern,0,0);
    }

    private boolean helper(char[] str, char[] pattern,int i,int j){
        //j到末尾了，看i是否到末尾
        if(j == pattern.length){
            return i == str.length;
        }

        //j+1有字符且不为*
        if(j + 1 == pattern.length || pattern[j+1] != '*'){
            //j到末尾，i不到末尾，不成立
            //i和j位置相同或者j位置为‘.’，当前位置匹配
            //然后看i+1和j+1是否匹配
            return i != str.length && (str[i] == pattern[j] || pattern[j] == '.')
                    && helper(str, pattern, i + 1, j + 1);
        }

        //j+1位置有字符且为*
        //针对aaaab 和 a*b的情况考虑
        //一直匹配到当前位置不相同或者j不为.的时候，因为.*也可以匹配
        while(i != str.length && (str[i] == pattern[j] || pattern[j] == '.')){
            if(helper(str, pattern, i, j + 2)){
                return true;
            }
            i++;
        }
        //然后看i位置和j+2位置
        //因为前面已经考虑到了j+1位置了
        return helper(str, pattern, i, j + 2);
    }
}
