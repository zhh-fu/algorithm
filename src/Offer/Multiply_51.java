package Offer;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * 解题思路：将第i个位置上的数视为1即可。
 *
 * B[i]的值可以看作矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 */
public class Multiply_51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A == null || A.length < 2) return B;
        B[0] = 1;
        //计算下三角
        for(int i=1;i<A.length;i++){
            B[i] = B[i-1] * A[i-1];
        }
        int tmp = 1;
        //计算上三角，并相乘
        //注意计算的下标起始点
        for(int i=A.length - 2;i>=0;i--){
            tmp *= A[i+1];
            B[i] *= tmp;
        }

        return B;
    }
}
