package Leetcode;

public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return "0";
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        long res = 0;
        for (int i=0;i<chs1.length;i++){
            for (int j=0;j<chs2.length;j++){
                int cur = (chs2[i] - '0')*10;

            }
        }
        return null;
    }
}
