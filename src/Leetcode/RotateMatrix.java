package Leetcode;

/**
 *  给定一个整型正方形矩阵matrix， 请把该矩阵调整成顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 *
 * 两个点确定一个矩阵
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //确定矩阵的两个点坐标
        int lr = 0;
        int lc = 0;
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;
        //当上下行相遇时停止
        while(lr < rr){
            swap(matrix, lr++, lc++, rr--, rc--);
        }
    }

    private void swap(int[][] matrix,int lr,int lc, int rr, int rc){
        int times = rr - lr;

        //找到四个数值之间的交换关系，原地进行交换即可
        for (int i=0;i<times;i++){
            int tmp = matrix[lr][lc + i];
            matrix[lr][lc + i] = matrix[rr - i][lc];
            matrix[rr - i][lc] = matrix[rr][rc - i];
            matrix[rr][rc - i] = matrix[lr + i][rc];
            matrix[lr + i][rc] = tmp;
        }
    }
}
