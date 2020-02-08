package AdvancedAlgorithm;

/**
 * 在一个无序数组中，找到第K小的数
 */
public class BFPRT {

    public static int getMinKthByBFPRT(int[] arr, int k){
        return bfprt(arr, 0 ,arr.length - 1, k - 1);
    }

    public static int bfprt(int[] arr, int begin, int end, int i){
        if (begin == end){
            return arr[begin];
        }
        //新数组的中位数的中位数
        int pivot  = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr,begin,end,pivot);
        //命中直接返回
        //小于则递归左区域
        //大于则递归右区域
        if (pivotRange[0] <= i && pivotRange[1] >= i){
            return arr[i];
        }
        else if (i < pivotRange[0]){
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        }
        else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    //以5个为一组进行划分，求得中位数的中位数
    public static int medianOfMedians(int[] arr,int begin, int end){
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        //return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
        return bfprt(mArr, 0, mArr.length - 1, (mArr.length / 2 + mArr.length % 2));
    }

    //求得每个数组的中位数
    public static int getMedian(int[] arr,int begin, int end){
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    //插入排序，对划分出来的小数组进行排序，求去中位数
    public static void insertionSort(int[] arr,int begin, int end){
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    //以求得最终的中位数作为轴进行排序
    //并返回等于区域
    public static int[] partition(int[] arr,int begin, int end, int pivotValue){
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        //快排
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
