package AdvancedAlgorithm.MonitonicStack;

import java.util.Stack;

public class MountainsPairs {
    public static long communication(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        int size = arr.length;
        //第一个最大值索引
        int maxIndex = 0;
        for (int i=1;i<arr.length;i++){
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];
        int index = nextIndex(size,maxIndex);
        long res = 0L;
        //单调栈，从上到下递增，最下面为最大值
        Stack<Pairs> stack = new Stack<>();
        stack.push(new Pairs(value));
        //数组中的元素未遍历完时
        while (index != maxIndex){
            value = arr[index];
            //单调栈压栈过程，弹出时计算规则
            while (!stack.isEmpty() && stack.peek().value < value){
                int times = stack.pop().times;
                //两边的对数 加上自己内部的
                res = res + getInternalSum(times) + times * 2;
            }
            //当入栈元素等于栈顶元素时，次数加1，否则直接压入
            if (!stack.isEmpty() && stack.peek().value == value){
                stack.peek().times++;
            }
            else{
                stack.push(new Pairs(value));
            }
            index = nextIndex(size,index);
        }

        //数组中的值遍历完
        while (!stack.isEmpty()){
            int times = stack.pop().times;
            //不管你是不是最底层，都要有自己内部的次数
            res = res + getInternalSum(times);
            if (!stack.isEmpty()) {
                //当栈顶为最大值且次数为1的时候 只计算一次，否则为两次
                if (stack.peek().value == arr[maxIndex] && stack.peek().times == 1) {
                    res = res + times;
                }
                else{
                    res = res +  times * 2;
                }
            }
        }
        return res;
    }

    //环形数组，计算索引
    public static int nextIndex(int size,int curSize){
        return curSize == size - 1 ? 0 : curSize + 1;
    }

    //计算Cn2 ，即n*(n-1)/2
    public static int getInternalSum(int times){
        return times == 1? 0 : times * (times - 1) / 2;
    }

    //统计值和出现的次数
    public static class Pairs{
        public int value;
        //只要出现最少为1
        public int times = 1;

        public Pairs(int value){
            this.value = value;
        }
    }
}
