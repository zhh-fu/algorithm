package Work;

import java.util.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            int[] bgn = new int[n];
            int num = 0;
            for(int i=0;i<n;i++){
                arr[i][0] = in.nextInt();
                bgn[i] = arr[i][0];
                arr[i][1] = in.nextInt();
            }
            Arrays.sort(bgn);
            for (int i=0;i<n;i++){
                int val = bgn[i];
                int index = 0;
                for (int j=0;j<n;j++){
                    if (arr[j][0] == val){
                        index = j;
                        break;
                    }
                }
                int next = arr[index][1];
                for (int j=0;j<n;j++){
                    if (arr[j][0] <= next || arr[j][1] <= next){
                        num++;
                    }
                }
                num = num - 1;
            }
            System.out.println(num);
        }
    }


}

