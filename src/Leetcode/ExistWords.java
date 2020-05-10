package Leetcode;

import java.util.Arrays;

public class ExistWords {
    public boolean exist(char[][] board, String word) {
        if (board == null || word.trim().equals("")){
            return false;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)){
                    /*
                    //使用标记数组
                    if(helper(i,j,0,board,word,mark)){
                        return true;
                    }
                    */
                    //不用标记数组
                    if(helper_2(i,j,0,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int row, int col, int index,
                           char[][] board, String word, boolean[][] mark){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || mark[row][col] || board[row][col] != word.charAt(index)){
            return false;
        }

        if (index == word.length() - 1) return true;
        mark[row][col] = true;
        //此处不能直接返回，需要进行复位操作
        //因为所使用的是标记数组的引用，导致在递归返回时，实际上没有走过的路被认为走过
        boolean res =  helper(row + 1, col, index + 1, board, word, mark) ||
                helper(row - 1, col, index + 1, board, word, mark) ||
                helper(row, col + 1, index + 1, board, word, mark) ||
                helper(row, col - 1, index + 1, board, word, mark);
        mark[row][col] = false;
        return res;
    }

    private boolean helper_2(int row, int col, int index,
                           char[][] board, String word){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)){
            return false;
        }

        if (index == word.length() - 1) return true;
        //记录并更改
        char tmp = board[row][col];
        board[row][col] = '/';
        boolean res =  helper_2(row + 1, col, index + 1, board, word) ||
                helper_2(row - 1, col, index + 1, board, word) ||
                helper_2(row, col + 1, index + 1, board, word) ||
                helper_2(row, col - 1, index + 1, board, word);
        //复位
        board[row][col] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] maxtrix = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        /*
        char[][] board = {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                         };
                         */
        System.out.println(new ExistWords().exist(maxtrix,"ABCESEEEFD"));
    }
}
