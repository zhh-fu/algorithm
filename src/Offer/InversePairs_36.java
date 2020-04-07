package Offer;

/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 解题思路：归并排序，小和问题
 * 也就是找一个数左边比它小的数有几个，注意是按照从大到小的顺序排列的
 * 左半部分有，右边部分也有，合并之后 还有
 */
public class InversePairs_36 {
    public int InversePairs(int [] array) {
        if(array == null || array.length < 2) return 0;
        return process(array,0,array.length-1) % 1000000007;
    }

    private int process(int[] arr,int L,int R){
        if(L == R) return 0;
        int mid = (R - L)/2 + L;
        return (process(arr,L,mid) + process(arr,mid+1,R) + merge(arr,L,mid,R)) % 1000000007;
    }

    private int merge(int[] arr,int L,int mid,int R){
        int[] res = new int[R - L + 1];
        int sum = 0,index = 0;
        int p1 = L,p2 = mid + 1;
        while(p1 <= mid && p2 <= R){
            if(arr[p1] < arr[p2]){
                res[index++] = arr[p2++];
            } else{
                //当出现p1 > p2时，p2及p2以后的数字都比p1小
                sum = (sum + R - p2 + 1) % 1000000007;
                res[index++] = arr[p1++];
            }
        }

        while(p1 <= mid){
            res[index++] = arr[p1++];
        }

        while(p2 <= R){
            res[index++] = arr[p2++];
        }

        for(int i=0;i<res.length;i++){
            arr[L++] = res[i];
        }

        return sum % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(new InversePairs_36().InversePairs(arr));
    }
}
