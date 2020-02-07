package AdvancedAlgorithm;

/**
 * 正则表达式匹配问题
 */
public class RegularExpressionMatch {
    //暴力递归
    //str[i~最后]能不能被exp[j~最后]的字符串匹配出来
    public static boolean process(char[] str, char[] exp, int i,int j){
        // j 位置上没有字符
        if (j == exp.length){
            return i == str.length;
        }
        // j+1 位置有字符且不为 *
        if (j + 1 == exp.length  && exp[j+1] != '*'){
            //j 没结束，i结束了，不成立
            //exp[j]和str[i]不匹配，或者exp[j] == '.'，当前位置才能匹配
            //且i+1 位置和 j+1 位置能够匹配
            return i != str.length && (exp[j] == str[i] || exp[j] == '.')
                    && process(str, exp, i + 1, j + 1);
        }

        //当前位置匹配，且exp的 j+1 位置为 '*'
        //出现 str = aaab  ， exp = a*  的时候
        while (i != str.length && (exp[j] == str[i] || exp[j] == '.')){
            // a* == 0个a
            if (process(str, exp, i, j + 2)){
                return true;
            }
            //a* = 1/2/3...个a
            i++;
        }
        return process(str, exp, i, j + 2);
    }
}
