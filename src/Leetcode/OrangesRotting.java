package Leetcode;

import java.util.Arrays;

public class OrangesRotting {
    private static int minutes = 0;
    private static boolean flag = true;
    public static int orangesRotting(int[][] grid) {
        boolean[][] mark = new boolean[grid.length][grid[0].length];

        changeMark(grid, mark);
        while (flag){
            for (int i=0;i<grid.length;i++){
                for (int j=0;j<grid[0].length;j++){
                    if (grid[i][j] == 2 && mark[i][j]){
                        helper(grid, i + 1, j);
                        helper(grid, i - 1, j);
                        helper(grid, i, j + 1);
                        helper(grid, i, j - 1);
                    }
                }
            }
            if (flag) break;

            if (!flag){
                flag = true;
                changeMark(grid, mark);
                minutes++;
            }
        }

        for (int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;

    }

    private static void helper(int[][] grid, int i, int j){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) return;

        if (grid[i][j] == 0 || grid[i][j] == 2){
            return;
        }

        grid[i][j] = 2;
        flag = false;
    }

    private static void changeMark(int[][] grid, boolean[][] mark){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 2){
                    mark[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        //int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }
}
