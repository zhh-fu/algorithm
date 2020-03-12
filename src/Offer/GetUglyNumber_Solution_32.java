package Offer;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution_32 {
    public static int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        int t1 = 0,t2 = 0,t3 = 0;
        int[] arr = new int[index];
        arr[0] = 1;
        for(int i=1;i<index;i++){
            arr[i] = Math.min(arr[t1]*2,Math.min(arr[t2]*3,arr[t3]*5));
            if(arr[t1]*2 == arr[i]) t1++;
            if(arr[t2]*3 == arr[i]) t2++;
            if(arr[t3]*5 == arr[i]) t3++;
        }
        return arr[index - 1];
    }

    public static void main(String[] args){
        System.out.println(GetUglyNumber_Solution(7));
    }
}
