package Offer;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount_66 {
    private int res = 0;
    public int movingCount(int threshold, int rows, int cols) {
        //记录该节点是否被访问过
        boolean[][] arr = new boolean[rows][cols];
        helper(threshold, 0, 0, arr, rows, cols);
        return res;
    }

    private void helper(int threshold, int rowCoord, int colCoord, boolean[][] arr, int rows, int cols){
        //下标越界或者访问过或者坐标不满足阈值，直接返回
        if (rowCoord < 0 || rowCoord >= rows || colCoord < 0 || colCoord >= cols ||
                arr[rowCoord][colCoord] || sum(rowCoord) + sum(colCoord) > threshold) return;
        res++;
        arr[rowCoord][colCoord] = true;
        /*
        下面为原始代码
        if (rowCoord < 0 || rowCoord >= rows || colCoord < 0 || colCoord >= cols) return;
        if (arr[rowCoord][colCoord]) return;
        if (sum(rowCoord) + sum(colCoord) > threshold){
            return;
        }else{
            res++;
            arr[rowCoord][colCoord] = true;
        }
         */

        helper(threshold, rowCoord, colCoord + 1, arr, rows, cols);
        helper(threshold, rowCoord, colCoord - 1, arr, rows, cols);
        helper(threshold, rowCoord + 1, colCoord, arr, rows, cols);
        helper(threshold, rowCoord - 1, colCoord, arr, rows, cols);
    }

    private int sum(int coordinate){
        int sum = 0;
        while (coordinate != 0){
            int mod = coordinate % 10;
            sum += mod;
            coordinate /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount_66().movingCount(10,7,7));
    }
}
