package Offer;

/**
 * 翻转单词顺序列
 * 例如，“student. a am I”，正确的句子应该是“I am a student.”。
 * 构造方法，翻转单词顺序
 *
 * 解题思路1、2：使用split函数分隔字符串。空间时间复杂度均为O(N)；
 * 阶梯思路3：先翻转整个句子，再依次翻转每个单词或者依次翻转每个单词，再翻转整个句子
 */
public class ReverseSentence_44 {
    public static String reverseSentence_1(String str) {
        if(str == null || str.equals(" ")) return str;
        String[] strs = str.split(" ");
        for(int i=0,j=strs.length - 1;i < j;i++,j--){
            String s = strs[i];
            strs[i] = strs[j];
            strs[j] = s;
        }
        String[] str1 = new String[strs.length*2-1];
        for(int i=0;i<str1.length;i++){
            if(i % 2 == 0){
                str1[i] = strs[i/2];
            } else{
                str1[i] = " ";
            }
        }
        String res = "";
        for(String s:str1){
            res += s;
        }
        return res;
    }

    public String reverseSentence_2(String str) {
        if(str == null || str.equals("")) return str;
        String[] strs = str.split(" ");
        if(strs.length == 0) return str;
        StringBuffer sb = new StringBuffer(str.length());
        for(int i=strs.length-1;i>0;i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }

    public static String reverseSentence_3(String str) {
        //注意此处的trim()
        if(str == null || str.trim().equals("")) return str;
        char[] chs = str.toCharArray();
        //先翻转整个句子
        reverse(chs,0,chs.length - 1);
        //记录其实位置
        int start = 0;
        for(int i=0;i<=chs.length;i++){
            //遇到空格或者到达末尾
            //因为最后一个位置可能没有空格，所以仍然是逆序
            if(i == chs.length || chs[i] == ' '){
                reverse(chs,start,i-1);
                start = i+1;
            }
        }
        //最后一个单词单独拉出来翻转
        //reverse(chs,start,chs.length-1);
        return String.valueOf(chs);
    }

    private static void reverse(char[] chs, int start, int end){
        while(start < end){
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        System.out.println(reverseSentence_3("student. a am I"));
    }
}
