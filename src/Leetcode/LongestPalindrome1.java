package Leetcode;

/**
 * @author zhh_fu
 * @description 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:输入:
 * "abccccdd"
 * 输出:7
 *
 * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @date 2020/7/2 22:17
 * @solution
 */

public class LongestPalindrome1 {
    public int longestPalindrome(String s) {
        if(s == null || s.trim().equals("")){
            return 0;
        }
        int[] chs = new int[52];
        //int[] chs = new int[58];
        char[] ch = s.toCharArray();
        int res = 0;
        for(int i=0;i<ch.length;i++){
            //chs[ch[i] - 'A']++;
            if(ch[i] >= 'a'){
                chs[ch[i] - 'a' + 26]++;
            } else{
                chs[ch[i] - 'A']++;
            }
        }

        for(int i=0;i<chs.length;i++){
            if(chs[i] != 0 && (chs[i] & 1) == 0){
                res += chs[i] / 2;
            }
        }

        return res * 2 + 1;
    }
}
