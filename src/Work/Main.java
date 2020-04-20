package Work;

import java.util.*;

public class Main {
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            //int[][] matrix = new int[n+1][m+1];
            int curMax = 0,sum = 0;
            for (int i=a;i<n+1;i++){
                for(int j=b;j<m+1;j++){
                    curMax = findMax(i, j, a, b);
                    sum += curMax;
                }
            }
            System.out.println(sum);
        }
    }

    public static int findMax(int curRow, int curCol, int a, int b){
        int max = 0,cur = 0;
        for (int i=curRow;i >= curRow - a + 1;i--){
            for (int j=curCol;j >= curCol - b + 1 ;j--){
                cur = (i * j) % 10;
                if (cur > max){
                    max = cur;
                }
            }
        }
        return max;
    }
    */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int[] arr = new int[N+1];
            int res = 0;
            for (int i=1;i<N+1;i++){
                arr[i] = in.nextInt();
            }
            //dp存储到达i用的最少花费
            int[] dp = new int[N+1];
            dp[1] = 0;
            for (int i=2;i<N+1;i++){

            }

        }
    }


}

/*
LinkedList<Integer> row = new LinkedList<>();
            LinkedList<Integer> col = new LinkedList<>();
            int curRow = a, curCol = b;
            int max = 0;
            for (int i=1;i<=a;i++){
                for (int j=1;j<=b;j++){
                    if (matrix[i][j] >= max){
                        row.add(i);
                        col.add(j);
                    }
                    while (row.isEmpty() || matrix[row.peekLast()][])
                }
            }
            while (curRow <= n){

            }
 */

