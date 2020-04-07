package Offer;

/**
 * 约瑟夫环问题
 * 用数组或者链表模拟整个过程即可
 * 或者用公式
 * f(1) = 0;
 * f(i) = (f(i-1) + m) % i;
 */
public class LastRemaining_Solution_46 {
    public static int lastRemaining_Solution_1(int n, int m) {
        if(n < 1 || m < 1) return -1;
        int[] arr = new int[n];
        int count = n, step = 0, i = -1;
        while(count > 0){
            i++;
            if(i == n) i = 0;
            if(arr[i] == -1) continue;
            step++;
            if(step == m){
                step = 0;
                count--;
                arr[i] = -1;
            }
        }
        return i;
    }

    public static int lastRemaining_Solution_2(int n, int m) {
        if (n == 0) return -1;
        if (n == 1){
            return 0;
        } else {
            return (lastRemaining_Solution_2(n-1,m) + m) % n;
        }
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining_Solution_1(40,7) == lastRemaining_Solution_2(40,7));
    }
}
