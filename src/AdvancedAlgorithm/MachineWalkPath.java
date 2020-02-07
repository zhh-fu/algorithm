package AdvancedAlgorithm;

/**
 *一条路有 N 步，有一个人机器人初始位于 M 位置，机器人一共可以走 p 步。
 * 最终机器人停留在K位置，一共有多少种可能走法？
 */
public class MachineWalkPath {
    /**
     *
     * @param N 共有 1~N 的位置
     * @param M 当前位于M 位置
     * @param P 可以走的步数
     * @param K 最终停留的位置
     * @return 一共有多少种可能走法
     */
    public static int ways(int N, int M, int P, int K){
        if (M < 1 || M > N || P < 0 || K < 1 || K > N || N < 2){
            return 0;
        }

        //basecase
        if (P == 0){
            return M == K ? 1 : 0;
        }

        int res = 0;
        //最左边，向右走
        if (M == 1){
            res = ways(N, M + 1,P - 1,K);
        }
        //最右边，向左走
        else if (M == N){
            res = ways(N,M - 1,P - 1,K);
        }
        //向两边走
        else {
            res = ways(N, M + 1,P - 1,K) + ways(N,M - 1,P - 1,K);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(ways(10,3,8,5));
    }
}
