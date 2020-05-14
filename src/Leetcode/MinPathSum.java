package Leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {
    public int min = Integer.MAX_VALUE;
    //暴力递归，超出时间限制
    public int minPathSum_1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        helper(0,0,0,grid);
        return min;
    }

    private void helper(int row, int col, int step, int[][] grid){
        if (row >= grid.length || col >= grid[0].length){
            return;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1){
            min = Math.min(min, step + grid[row][col]);
            return;
        }
        helper(row + 1, col, step + grid[row][col], grid);
        helper(row, col + 1, step + grid[row][col], grid);
    }

    //动态规划，时间空间复杂度均为O(MN)
    public int minPathSum_2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    //动态规划，时间复杂度均为O(MN)，空间复杂度为O(1)
    //dp的结果直接存储在原始数组中的，但是并不推荐，因为会修改原数组
    public int minPathSum_3(int[][] grid) {
        for (int i=1;i<grid.length;i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int i=1;i<grid[0].length;i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinPathSum().minPathSum_3(arr));
    }
}
