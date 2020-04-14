package TestWorkSpace;

import BasicConstructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class test {
   public static int  light(){
       boolean[] light = new boolean[101];
       for (int i=1;i<= 100;i++){
           for (int j=1;j<light.length;j=j+i){
               light[j] = !light[j];
           }
       }
       int index = 0;
       for (int i=1;i<101;i++){
           if (light[i]) index++;
       }
       return index;
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        if(m < 1 || n < 1 || A == null || B == null) return;
        int p1 = m-1, p2 = n-1;
        int index = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(A[p1] > B[p2]){
                A[index--] = A[p1];
                A[p1--] = 0;

            } else{
                A[index--] = B[p2--];
            }
        }

        while(p2 >= 0){
            A[index--] = B[p2--];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        merge(A,3,B,3);
        for (int i:A){
            System.out.println(i);
        }
    }
}
