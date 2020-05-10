package Offer;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。例如
 * a  b  c  e
 * s  f  c  s
 * a  d  e  e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 解题思路：回溯法，任意位置开始，任何一个方向为真即可
 */
public class HasPath_65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || matrix.length == 0 || rows < 1 || cols < 1
                || str == null || str.length == 0)
            return false;
        boolean[] arr = new boolean[matrix.length];
        //判断任意开始位置
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (str[0] == matrix[i*cols + j]){
                    if (helper(i,j,0,arr,matrix,rows,cols,str)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int curRow, int curCol, int index, boolean[] arr, char[] matrix, int rows, int cols, char[] str){
        //越界或者访问过或者不相等直接返回false
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols
                || arr[curRow*cols + curCol] || matrix[curRow*cols + curCol] != str[index]){
            return false;
        }
        //到达最后，且相同的判定在上一个if完成过
        if (index == str.length - 1)
            return true;
        //访问过变为true
        arr[curRow*cols + curCol] = true;

        //只要有一个为真即可
        //不能直接返回，因为标记数组需要复位
        //如果没有复位操作可能导致最终误判
        //因为所使用的是标记数组的引用，导致在递归返回时，实际上没有走过的路被认为走过
        boolean res = helper(curRow + 1, curCol, index + 1, arr, matrix, rows, cols, str) ||
               helper(curRow - 1, curCol, index + 1, arr, matrix, rows, cols, str) ||
               helper(curRow, curCol + 1, index + 1, arr, matrix, rows, cols, str) ||
               helper(curRow, curCol - 1, index + 1, arr, matrix, rows, cols, str);
        //执行此处会使标记数组复位
        arr[curRow*cols + curCol] = false;
        return res;
    }

    public static void main(String[] args) {
        char[] maxtrix = {'A','B','C','E','S','F','E','S','A','D','E','E'};
        char[] str = {'A','B','C','E','S','E','E','E','F','S'};
        System.out.println(new HasPath_65().hasPath(maxtrix,3,4,str));
    }
}
