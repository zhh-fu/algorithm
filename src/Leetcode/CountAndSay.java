package Leetcode;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        if(n < 1) return -1+"";
        if(n == 1) return 1+"";
        int index = 1;
        String pre = "1";
        while (index != n){
            StringBuffer sb = new StringBuffer();
            int k = 1;
            for (int i=0;i<pre.length();i++){
                if (i < pre.length() - 1 &&  pre.charAt(i) == pre.charAt(i+1)){
                    k++;
                    continue;
                }
                sb.append(k);
                sb.append(pre.charAt(i));
                k = 1;
            }
            index++;
            pre = sb.toString();
        }
        return pre;
    }

    public static String countAndSay_1(int n) {
        StringBuffer sb = new StringBuffer();
        if(n == 1) return "1";
        //利用递归，相当于让系统帮忙执行了while循环，其他的逻辑均为发生变化
        String pre = countAndSay_1(n-1);
        int k = 1;
        for (int i=0;i<pre.length();i++){
            if (i < pre.length() - 1 &&  pre.charAt(i) == pre.charAt(i+1)) {
                k++;
                continue;
            }
            sb.append(k).append(pre.charAt(i));
            k = 1;
        }
        /*
        此处写为该样子也没有影响
        pre = sb.toString();
        return pre;
         */
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
        System.out.println(countAndSay(9));
        System.out.println(countAndSay(10));

    }
}
