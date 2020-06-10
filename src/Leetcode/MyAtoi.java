package Leetcode;

public class MyAtoi {
    public static int myAtoi(String str) {
        if(str == null || str.trim().equals("")) return 0;
        str = str.trim();
        boolean flag = true;
        int num = 0;
        if ((str.charAt(0) < '0' || str.charAt(0) > '9') && (str.charAt(0) != '+' && str.charAt(0) != '-')){
            return 0;
        }

        for (int i=0;i<str.length();i++){
            if (i == 0){
                if (str.charAt(i) == '-'){
                    flag = false;
                } else if (str.charAt(i) == '+'){
                    continue;
                } else{
                    num = num * 10 + str.charAt(i) - '0';
                }
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            } else {
                if (num > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10){
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + str.charAt(i) - '0';
            }
        }

        return flag ? num : -num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  -  000456123"));
    }
}
