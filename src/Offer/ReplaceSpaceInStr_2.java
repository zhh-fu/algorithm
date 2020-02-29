package Offer;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;

/**
 * 字符串中的空格替换
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路1：直接使用replace或者replaceAll方法。但是显然不是考察如此；
 * 思路2：将str变为char[]，再新建一个StringBuffer，遇到空格就替换，不是直接追加；
 *      时间复杂度为O(N),空间复杂度为O(N)；
 * 思路3：从左向右遍历空格数量，然后从右向左替换空格。
 */
public class ReplaceSpaceInStr_2 {
    private static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
//        for (int i = 0; i < str.length(); i++){
//            if (str.charAt(i) == ' '){
//                str.replace(i, i + 1, "%20");
//            }
//        }
        return str.toString().replaceAll(" ","%20");
    }

    private static String replaceSpace1(StringBuffer str){
        if (str == null) return null;
        char[] chs = str.toString().toCharArray();
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < chs.length; i++){
            if (chs[i] == ' '){
                str1.append("%20");
            } else{
                str1.append(chs[i]);
            }
        }
        return str1.toString();
    }

    private static String replaceSpace2(StringBuffer str){
        if (str == null) return null;
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        char[] chs = new char[str.length() + 2*count];
        for (int i = str.length() - 1;i >= 0;i--){
            if (str.charAt(i) != ' '){
                chs[i + 2*count] = str.charAt(i);
            } else{
                count--;
                chs[i + 2*count + 2] = '0';
                chs[i + 2*count + 1] = '2';
                chs[i + 2*count] = '%';
            }
        }
        return String.valueOf(chs);

    }

    public static void main(String[] args){
        StringBuffer str = new StringBuffer("We Are Happy ");
//        StringBuffer str1 = new StringBuffer("We Are Happy ");
//        StringBuffer str2 = new StringBuffer(" We Are Happy ");
//        StringBuffer str3 = new StringBuffer(" ");
//        StringBuffer str4 = new StringBuffer("");
//        System.out.println(replaceSpace(str));
//        System.out.println(replaceSpace(str1));
//        System.out.println(replaceSpace(str2));
//        System.out.println(replaceSpace(str3));
        System.out.println(replaceSpace2(str));
    }


}
