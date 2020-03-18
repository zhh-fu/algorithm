package Offer;

/**
 * 左旋转字符串
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 * 解题思路1：追加法，时间空间复杂度均为O(N)
 * 解题思路2：截取字符串
 * 解题思路3：三次翻转，(BA) = (ATBT)T,T为翻转
 */
public class LeftRotateString_43 {
    public String leftRotateString_1(String str,int n) {
        //注意此处null 和 “”的判定
        if(str.equals("") || str == null || n < 1) return str;

        char[] chs = str.toCharArray();
        int num = n % chs.length;
        if(num == 0) return str;
        int i = num + 1;
        StringBuffer sb = new StringBuffer();
        sb.append(chs[num]);
        while(i != num){
            if(i == chs.length) i = 0;
            sb.append(chs[i++]);
        }
        return sb.toString();
    }

    //截取字符串
    public String leftRotateString_2(String str,int n) {
        if(str == null || str.equals("") || n < 1) return str;
        int len = str.length();
        n = n % len;
        str = str + str;

        //substring 从 n开始，到len+n-1结束
        //substring(beginIndex,endIndex)，beginIndex包括，endIndex不包括
        return str.substring(n,len + n);
    }

    //三次翻转
    public String leftRotateString_3(String str,int n) {
        if(str == null || str.equals("") || n < 1) return str;
        char[] chs = str.toCharArray();
        int len = chs.length;
        n = n % len;
        if(n == 0) return str;
        //A的翻转
        reverse(chs,0,n - 1);
        //B的翻转
        reverse(chs,n,len - 1);
        //AB的翻转
        reverse(chs,0,len - 1);
        return String.valueOf(chs);
    }

    private void reverse(char[] chs,int start,int end){
        while(start < end){
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }



}
