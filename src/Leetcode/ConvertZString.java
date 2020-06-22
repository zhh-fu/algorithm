package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 以二维数组的思想思考，但是并不使用二维数组
 * 看傻了我，只会用二维数组来计算
 */
public class ConvertZString {
    public static String convert(String s, int numRows) {
        //注意特殊情况的判断
        if(s == null || s.length() <= numRows || numRows < 2) return s;
        //使用list来存储每一行的信息
        List<StringBuffer> list = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            list.add(new StringBuffer());
        }
        int i = 0, flag = -1;
        for (char ch : s.toCharArray()){
            //将当前字符填入当前行
            list.get(i).append(ch);
            //当到第一行或者最后一行时，更新方向
            if (i == 0 || i == numRows - 1) flag = -flag;
            //更新当前行
            i += flag;
        }
        StringBuffer sbs = new StringBuffer();
        for (StringBuffer sb : list){
            sbs.append(sb);
        }
        return sbs.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
