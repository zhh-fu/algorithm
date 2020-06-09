package Leetcode;

public class MyAtoi {
    public static int myAtoi(String str) {
        if(str == null || str.trim().equals("")) return 0;
        str = str.trim();
        boolean flag = true;
        long num = 0;
        if ((str.charAt(0) < '0' || str.charAt(0) > '9') && (str.charAt(0) != '+' && str.charAt(0) != '-')){
            return 0;
        }

        char[] chs = str.toCharArray();
        for (int i=0;i<chs.length;i++){
            if (i == 0){
                if (chs[i] == '-'){
                    flag = false;
                } else if (chs[i] == '+'){
                    continue;
                } else{
                    num = num * 10 + chs[i] - '0';
                }
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            } else {
                num = num * 10 + chs[i] - '0';
            }
            if (num >= 0 - Integer.MIN_VALUE){
                num = Integer.MIN_VALUE;
            }
        }

        if (flag){
            num = 0 - num;
        }

        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
    }
}
