package Offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 解题思路：使用辅助栈，
 *          将pushA中的元素放入栈中，每次比较栈顶元素和当前的popA元素是否相同
 *          如果相同则将栈顶元素弹出，并将popA移向下一个，循环进行，直到栈顶元素和popA不相同
 *          如果不相同，进行下一个即可。
 */
public class IsPopOrder_21 {
    //我的代码，丑陋
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        while(i < pushA.length && j < popA.length){
            if (stack.isEmpty()){
                stack.push(pushA[i]);
            }
            if (stack.peek() != popA[j] && i < pushA.length-1){
                stack.push(pushA[++i]);
            } else if (stack.peek() == popA[j]){
                stack.pop();
                j++;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }

    //同样的思路，实现的代码简洁
    private static boolean IsPopOrder_1(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,3,2,5,1};
        System.out.println(IsPopOrder_1(arr1,arr2));
    }
}
