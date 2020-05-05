package Leetcode;

/**
 * 岛问题
 */
public class IslandProblem {
    private int num = 0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return num;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    num++;
                    helper(grid, i, j);
                }
            }
        }
        return num;
    }


    private void helper(char[][] grid, int row, int col){
        if(row >= grid.length || row < 0
                || col >= grid[0].length || col < 0
                || grid[row][col] == '0') return;
        if(grid[row][col] == '1'){
            grid[row][col] = '0';
            helper(grid, row + 1, col);
            helper(grid, row - 1, col);
            helper(grid, row, col + 1);
            helper(grid, row, col - 1);
        }
    }
}
