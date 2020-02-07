package AdvancedAlgorithm.MonitonicStack;

import java.util.Stack;

/**
 * 求多列矩阵中的最大连续面积。
 */
public class MaxRectangle {
    public static int  maxMatrix(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        //代表每一行为底的数组
        int[] height = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                //更新height
                //如果当前值为 0 ，则直接赋值 0
                //如果当前值为1 ，则在原来的基础上+1
                height[j] = matrix[i][j] == 0 ? 0:height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFromButtom(height));
        }
        return maxArea;
    }
    public static int maxRecFromButtom(int[] height){
        if (height == null || height.length == 0) return 0;

        int maxArea = 0;
        //单调栈，存放的是数组的下边，从底到顶递增
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<height.length;i++){
            //单调栈，当前元素比栈顶所代表元素小时，弹出栈顶元素
            //此时 数组未遍历完
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                /**
                 * @cur     弹出的元素，以它为轴
                 * @start   左边界
                 * @i       右边界
                 * @curArea 当前的面积
                 */
                int cur = stack.pop();
                //栈为空则 左边界为 -1 ，不为空 则左边界为当前栈顶元素
                int start = stack.isEmpty()? -1 : stack.peek();
                int curArea = (i - start - 1) * height[cur];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        /**
         * @explain            当前数组中的元素全部遍历完成
         * @cur                弹出的元素，以它为轴
         * @start              左边界
         * @height.length      右边界,统一为N
         * @curArea            当前的面积
         */
        while (!stack.isEmpty()){
            int cur = stack.pop();
            int start = stack.isEmpty()? -1 : stack.peek();
            int curArea = (height.length - start - 1) * height[cur];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
