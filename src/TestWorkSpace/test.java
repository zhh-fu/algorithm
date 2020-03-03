package TestWorkSpace;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        int[] arr = {2,5,3,7,5,1,9,4};
        insertSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1;i<arr.length;i++){
            int index = i;
            for (int j = i-1;j>=0;j--){
                if (arr[j] > arr[index]){
                    swap(arr,j,index);
                    index--;
                }
            }
        }
        //return arr;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
