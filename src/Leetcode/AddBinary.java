package Leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 倒序计算，最后看进位是否为1，然后翻转即可
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int mod = 0;
        //倒序计算
        for(int ai = a.length() - 1, bi = b.length() - 1; ai >= 0 || bi >= 0;ai--, bi--){
            mod += (ai >= 0 ? (a.charAt(ai) - '0') : 0);
            mod += (bi >= 0 ? (b.charAt(bi) - '0') : 0);
            //计算当前位
            sb.append(mod % 2);
            //计算进位
            mod = mod / 2;
        }
        //如果进位为1也要追加，0则不用管
        if (mod == 1){
            sb.append(mod);
        }
        //最后翻转即可
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}
