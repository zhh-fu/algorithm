package Leetcode;

/**
 * 最长回文子串，中心扩展法
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s == null) return null;

        char[] charArr = s.toCharArray();
        char[] chs = new char[2 * s.length() + 1];
        for(int i=0,j=0;i<chs.length;i++){
            chs[i] = (i & 1) == 1 ? charArr[j++] : '#';
        }

        int max = 0,index1 = 0,index2 = 0;
        for(int i=0;i<chs.length;i++){
            int p1 = i;
            int p2 = i;
            while(p1 >= 0 && p2 < chs.length){
                if (chs[p1] == chs[p2]){
                    p1--;
                    p2++;
                } else{
                    break;
                }
            }
            if (max < p2 - p1){
                max = p2 - p1;
                index1 = p1 + 1;
                index2 = p2 - 1;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i=index1+1;i<=index2;i=i+2){
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str2 = "       ";
        System.out.println(longestPalindrome(str2));

    }
}
