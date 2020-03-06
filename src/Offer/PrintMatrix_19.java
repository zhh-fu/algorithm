package Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,
 * 8,12,16,15,
 * 14,13,9,5,
 * 6,7,11,10.
 *
 * 解题思路：由左上角和右下角的坐标确定矩阵，
 *          然后判断是否位于同一行或者同一列，
 *          若不是则顺时针打印。
 */
public class PrintMatrix_19 {
    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int lr = 0;
        int lc = 0;
        int rr = matrix.length - 1;
        int rc = matrix[0].length - 1;

        while(lr <= rr && lc <= rc){
            print(matrix,lr++,lc++,rr--,rc--,list);
        }
        return list;
    }

    private static void print(int[][] matrix,int lr, int lc, int rr, int rc, ArrayList<Integer> list){
        if(lr == rr){
            while(lc <= rc){
                list.add(matrix[lr][lc]);
                lc++;
            }
        } else if(lc == rc){
            while(lr <= rr){
                list.add(matrix[lr][lc]);
                lr++;
            }
        } else{
            for(int i=lc;i<rc;i++){
                list.add(matrix[lr][i]);
            }
            for(int i=lr;i<rr;i++){
                list.add(matrix[i][rc]);
            }
            for(int i=rc;i>lc;i--){
                list.add(matrix[rr][i]);
            }
            for(int i=rr;i>lr;i--){
                list.add(matrix[i][lc]);
            }
        }
    }

    public static void main(String[] args){
        int[][] arr = {{1,2},{3,4}};
        System.out.println(Arrays.asList(printMatrix(arr)));
    }
}
