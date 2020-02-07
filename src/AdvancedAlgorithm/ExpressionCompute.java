package AdvancedAlgorithm;

import java.util.LinkedList;

/**
 * 字符串公式计算
 */
public class ExpressionCompute {

    public static int expressionCompute(String str){
        return value(str.toCharArray(),0)[0];
    }

    //返回数组arr长度为2
    //arr[0] 代表计算结果
    //arr[1] 代表计算的结束位置
    //index  代表计算的开始位置
    public static int[] value(char[] chs,int index){
        //双端队列，存储加减过程
        LinkedList<String> que = new LinkedList<>();

        //pre 用于收集数字
        int pre = 0;
        int[] rtn = null;

        while (index < chs.length && chs[index] != ')'){
            if (chs[index] >= '0' && chs[index] <= '9'){
                pre = pre * 10 + chs[index++] - '0';
            }
            //代表遇到了加减乘除符号
            else if (chs[index] != '('){
                addNum(que, pre);
                que.add(String.valueOf(chs[index++]));
                // 数字归零
                pre = 0;
            }
            //遇到了左括号
            else {
                //进入下一个递归
                rtn = value(chs,index + 1);
                //返回的结果存在 pre 中，以便下一次加入
                pre = rtn[0];
                //index 存储下一个符号的位置
                index = rtn[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[]{ getNum(que), index};
    }

    // 如果是+- 就进栈， 否则将下一个数字与栈顶数字进行
    //  “*”， “/” 操作后将结果入栈
    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            }
            else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    //最终栈内只剩下数字见的加减操作，计算处理后将结果返回即可。
    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
