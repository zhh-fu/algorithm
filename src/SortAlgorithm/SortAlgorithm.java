package SortAlgorithm;

public class SortAlgorithm {
    //冒泡排序
    public static void bubleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i=arr.length - 1;i>0;i--){
            for (int j=0;j<i;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    //选择排序
    //基本思想就是（有n个数据，即长度为n）在 n - start +1 个记录中（start为大循环的开始）选取最小的记录作为有序序列的第start个记录
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    //插入排序
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1;i<arr.length;i++){
            for (int j = i-1;j>=0;j--){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    //桶排序
    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int[] bucket = new int[max+1];
        for (int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int index = 0;
        for (int i=0;i<bucket.length;i++){
            while (bucket[i] != 0){
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length - 1);
    }

    private static void process(int[] arr, int L, int R){
        if (L < R){
            int index = (int) Math.random()*(R - L + 1);
            swap(arr,L+index,R);
            int[] equal = new int[2];
            equal = partition(arr,L,R);
            process(arr,L,equal[0]-1);
            process(arr,equal[1]+1,R);
        }
    }

    private static int[] partition(int[] arr,int L,int R){
        int less = L - 1;
        int more = R;
        int cur = L;
        while (cur < more){
            if (arr[cur] < arr[R]){
                swap(arr,cur++,++less);
            } else if (arr[cur] > arr[R]){
                swap(arr,cur,--more);
            } else{
                cur++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }

    //归并排序
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L == R){
            return;
        }
        int mid = (R - L)/2 + L;
        process1(arr,L,mid);
        process1(arr,mid + 1,R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] result = new int[R - L + 1];
        int p1 = L,p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= R){
            if (arr[p1] < arr[p2]){
                result[index++] = arr[p1++];
            } else{
                result[index++] = arr[p2++];
            }
        }

        while(p1 <= mid){
            result[index++] = arr[p1++];
        }

        while(p2 <= R){
            result[index++] = arr[p2++];
        }

        for (int i=0;i<result.length;i++){
            arr[L++] = result[i];
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0;i<arr.length;i++){
            heapInsertion(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);

        while (size > 0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size){
            int right = left + 1;
            int largerst;
            if (right < size && arr[right] > arr[left]){
                largerst = right;
            } else {
                largerst = left;
            }

            largerst = arr[index] > arr[largerst] ? index : largerst;
            if (index == largerst){
                break;
            }

            swap(arr,largerst,index);
            index = largerst;
            left = index * 2 + 1;
        }
    }

    private static void heapInsertion(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }




    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
