package TestWorkSpace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = 0;
        while(in.hasNext()) {
            length = in.nextInt();
            int[] arr = new int[length];
            int[] copy = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = in.nextInt();
                copy[i] = arr[i];
            }

            Arrays.sort(copy);
            int left = 0, right = length - 1;
            while (left < length && arr[left] == copy[left]) {
                left++;
            }
            while (right >= 0 && arr[right] == copy[right]) {
                right--;
            }

            int i = 0;
            for (; i <= right - left; i++) {
                if (copy[left + i] != arr[right - i]) {
                    break;
                }
            }
            if (i > right - left) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
class Example{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int len = scanner.nextInt();
            int[] array = new int[len];
            int[] copy = new int[len];
            for(int i=0;i<len;i++)
            {
                array[i] = scanner.nextInt();
                copy[i] = array[i];
            }
            Arrays.sort(copy);
            int left = 0,right = len-1;
            while(left<len && copy[left]==array[left]) left++;
            while(right>=0 && copy[right]==array[right]) right--;


            int i;
            for(i=0;i<=right-left;i++)
            {
                if(copy[left+i]!=array[right-i])
                    break;
            }
            if(i>right-left)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

class Example1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            String str = scanner.next();
            int length = str.length();
            int left = 0,right = length - 1;
            boolean flag = false;
            while(left != right){
                //if (str.charAt(left) != str.charAt())
            }
            int len = scanner.nextInt();
            int[] array = new int[len];
            int[] copy = new int[len];
            for(int i=0;i<len;i++)
            {
                array[i] = scanner.nextInt();
                copy[i] = array[i];
            }
            Arrays.sort(copy);
            while(left<len && copy[left]==array[left]) left++;
            while(right>=0 && copy[right]==array[right]) right--;


            int i;
            for(i=0;i<=right-left;i++)
            {
                if(copy[left+i]!=array[right-i])
                    break;
            }
            if(i>right-left)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

