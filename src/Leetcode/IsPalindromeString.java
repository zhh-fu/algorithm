package Leetcode;

/**
 * @author zhh_fu
 * @description
 * @date 2020/6/30 22:26
 * @solution
 */

public class IsPalindromeString {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.trim().equals("")) return true;
        s = s.trim().toLowerCase();
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !isValid(s.charAt(l))){
                l++;
            }
            while (l < r && !isValid(s.charAt(r))){
                r--;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char ch){
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = null;
        System.out.println(new IsPalindromeString().isPalindrome(str));
    }
}
