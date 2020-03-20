package Offer;

/**
 * 求1+2+3+...+n.
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 解题思路1：利用&& 和 ||的短路特性
 *      (表达式1）&&(表达式2) 如果表达式1为假，则表达式2不会进行运算，即表达式2“被短路”
 *      (表达式1）||(表达式2) 如果表达式1为真，则表达式2不会进行运算，即表达式2“被短路”
 * 解题思路2：利用异常退出流程
 */
public class Sum_Solution_47 {
    public int sum_Solution_1(int n) {
        int res = n;
        //与逻辑的短路特性，第一个条件为假则直接返回，不进行下面条件的计算
        boolean ac = (n > 0) && (res += sum_Solution_1(n-1)) > 0;
        return res;
    }

    //利用异常退出
    public int sum_Solution_2(int n){
        return sum(n);
    }

    public int sum(int n){
        try{
            int i = 2 % n;
            return n + sum(--n);
        }
        catch(Exception ex){
            //注意在发生异常时，n为0，所以退出0
            //经实测，n也可以生效
            //return n;
            return 0;
        }
    }
}
