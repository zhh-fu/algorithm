package Offer;

/**
 * 把字符串转化为整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 解题思路：使用ASCII码确定数字，判断正负和是否越界
 */
public class StrToInt_49 {
    public static int strToInt(String str) {
        if(str == null || str.trim().equals("")) return 0;
        boolean isNegative = false;
        char[] chs = str.toCharArray();
        long res = 0;
        for(int i=0;i<chs.length;i++){
            //使用ASCII码判断数值
            if(chs[i] >= 48 && chs[i] <= 57){
                res = res * 10 + chs[i] - 48;
            } else{
                //判断正负号
                if(i == 0 && (chs[i] == '+' || chs[i] == '-')){
                    isNegative = chs[i] != '+';
                } else{
                    return 0;
                }

            }
        }
        //判断是否溢出了Integer.MAX_VALUE或者Integer.MIN_VALUE
        if(isNegative){
            return 0 - res < Integer.MIN_VALUE ? 0 :  0 - (int) res;
        } else{
            return res > Integer.MAX_VALUE ? 0 : (int) res;
        }
    }

    public static void main(String[] args) {
        System.out.println(strToInt("1233"));
    }
}
