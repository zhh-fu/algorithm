package Offer;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解题思路1：遍历
 * 解题思路2：二分法找到上下界
 * 解题思路3：数组中的数都是整数，找到 k+0.5 和 k-0.5的位置即可。
 */
public class GetNumberOfK_37 {
    public int getNumberOfK_1(int [] array , int k) {
        if(array == null || array.length == 0){
            return  0;
        }
        return getUpper(array , k) - getLower(array , k) + 1;
    }

    private int getUpper(int [] array , int k){
        int l = 0,h = array.length - 1;
        int mid = (h + l)/2;
        while(l <= h){
            if(array[mid] <= k){
                l = mid + 1;
            } else{
                h = mid - 1;
            }
            mid = (h + l)/2;
        }
        return h;
    }

    private int getLower(int [] array , int k){
        int l = 0,h = array.length - 1;
        int mid = (h + l)/2;
        while(l <= h){
            if(array[mid] < k){
                l = mid + 1;
            } else{
                h = mid - 1;
            }
            mid = (h + l)/2;
        }
        return l;
    }

    public int getNumberOfK_2(int [] array , int k) {
        if(array == null || array.length == 0){
            return  0;
        }
        int res = 0;
        for (int i = 0;i<array.length;i++){
            if (array[i] == k) res++;
        }
        return res;
    }

    public int getNumberOfK_3(int [] array , int k) {
        if(array == null || array.length == 0){
            return  0;
        }
        return getLocation(array , k + 0.5) - getLocation(array , k - 0.5);
    }

    private int getLocation(int [] array , double k){
        int l = 0,h = array.length - 1;
        int mid = (h + l)/2;
        while(l <= h){
            if(array[mid] < k){
                l = mid + 1;
            } else if(array[mid] > k){
                h = mid - 1;
            }
            mid = (h + l)/2;
        }
        return h;
    }



    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,4,5,6,6,7};
        System.out.println(new GetNumberOfK_37().getNumberOfK_1(arr,4));
    }
}
