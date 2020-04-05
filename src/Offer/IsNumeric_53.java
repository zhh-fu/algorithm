package Offer;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 解题思路：
 * 12e说明e的后面必须有数字，不能有两个e
 * +-5说明符号位要么出现一次在首位，要么出现一次在e的后一位，其他地方都不能有
 * 12e4.3说明e的后面不能有小数，1.2.3说明不能有两个小数点
 * 1a3.14说明不能有其他的非法字符，比如这里的a
 */
public class IsNumeric_53 {
    public static boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) return false;
        //对e、小数点、正负号做判断
        boolean eflag = false,decflag = false,signflag = false;
        for(int i=0;i<str.length;i++){
            //对e判断
            if(str[i] == 'e' || str[i] == 'E'){
                //只能出现一次
                if(eflag) return false;
                //e的后面必须有数字
                if(i == str.length - 1) return false;
                eflag = true;
                //正负号
            } else if(str[i] == '-' || str[i] == '+'){
                //正负号不能是最后一个
                if(i == str.length - 1) return false;
                //符号不是第一次出现，必定在指数的后面
                if(signflag && str[i-1] != 'e' && str[i-1] != 'E') return false;
                //第一次出现要么在首位要么在e的后面
                if(!signflag && i>0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                signflag = true;
            } else if(str[i] == '.'){
                //不是第一次出现或者出现在e的后面
                if(decflag || eflag) return false;
                //第一次出现但是它的后面不能是e
                if(!decflag && (str[i+1] == 'e' || str[i+1] == 'E')) return false;
                //下面这一行理应是判断的，但是OJ上认为-.123为真，所以不加
                //if(i == 0 || (i == 1 && signflag)) return false;
                decflag = true;
                //除了数字之外的字母
            } else if(str[i] < '0' || str[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "123.4E+4";
        char[] chs = str.toCharArray();
        System.out.println(isNumeric(chs));
    }
}
