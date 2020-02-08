package AdvancedAlgorithm;

/**
 * 字符串匹配问题
 * str1 中是否包含 str2
 */
public class KMPAlgorithm {

    public static int kmpAlgorithm(String str1, String str2){
        return getIndexOf(str1, str2);
    }

    public static int getIndexOf(String str1,String str2){
        if (str1 == null || str2 == null ||
                str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }

        char[] ss = str1.toCharArray();
        char[] ms = str2.toCharArray();
        int p1 = 0;
        int p2 = 0;
        //后移的str2，所以next只和str2 有关
        int[] next = getNextArray(ms);
        while (p1 < ss.length && p2 < ms.length){
            //两者相同时候，双指针同时移动
            if (ss[p1] == ms[p2]){
                p1++;
                p2++;
            }
            //str2的第一个字符都不能和str1的p1位置匹配,str1的指针向后移动
            else if (next[p2] == -1){
                p1++;
            }
            else{
                //str2的指针可以向前跳，移动至next[p2]位置，
                // 是最长前缀的下一个位置，然后和p1进行更新比较
                p2 = next[p2];
            }
        }
        //str2的指针已经滑到了最后
        return p2 == ms.length ? p2 - p1 : -1;
    }

    public static int[] getNextArray(char[] chs){
        if (chs.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        //当前来到的位置index
        int index = 2;
        //匹配成功的位置，也是跳转至的位置
        int cn = 0;
        while (index < chs.length){
            //如果当前匹配前缀位置的字符和我前一个字符的相同
            if (chs[index - 1] == chs[cn]){
                //index位置的匹配长度就是前缀跳到的位置加1
                next[index++] = ++cn;
            }
            else if (cn > 0){
                //如果匹配前缀位置的字符和我前一个字符不相同
                //如果匹配前缀cn可以往前跳，
                //跳到cn位置next数组位置
                cn = next[cn];
            }
            else {
                //不能向前跳
                next[index++] = 0;
            }
        }
        return next;
    }
}

