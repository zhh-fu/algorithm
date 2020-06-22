package TestWorkSpace;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[][] chars = new char[3][2];
        System.out.println(chars[1][1] == 0);
    }
}
























    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            char[] chs = str.toCharArray();
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                int order = in.nextInt();
                if (order == 1){
                    int pos = in.nextInt();
                    String c = in.next();
                    chs[pos - 1] = c.charAt(0);
                } else if (order == 2){
                    int l = in.nextInt();
                    int r = in.nextInt();
                    HashSet<Character> set = new HashSet<>();
                    for (int j=l;j<=r;j++){
                        set.add(chs[j-1]);
                    }
                    list.add(set.size());
                }
            }
            for (int num : list){
                System.out.println(num);
            }
        }
    }

}
/*
    public static int num = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String word = in.next();
            int N = in.nextInt();
            String[] strs = new String[N];
            char[] chs = word.toCharArray();
            for (int i=0;i<N;i++){
                strs[i] = in.next();
            }
            helper(chs,strs,0);
            System.out.println(num % 835672545);
            num = 0;
        }
    }

    private static void helper(char[] chs, String[] strs, int index){
        if (index == chs.length){
            num++;
            return;
        }
        if(index > chs.length){
            return;
        }
        for (int i=0;i<strs.length;i++){
            int mark = 0;
            for (int j=0;j<strs[i].length();j++){
                if(index + j < chs.length) {
                    if (chs[index + j] == strs[i].charAt(j)) {
                        mark++;
                    }
                }
            }
            if (mark == strs[i].length()){
                helper(chs, strs, index + mark);
            }
        }
    }

}
/*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int N = in.nextInt();
            StringBuffer sb = new StringBuffer();
            Stack<String> stack = new Stack<>();
            ArrayList<Character> list = new ArrayList<>();
            for (int i=0;i<N;i++){
                int order = in.nextInt();
                if (order == 1){
                    String str = in.next();
                    sb.append(str);
                    stack.push(str);
                    stack.push(1+"");
                } else if (order == 2){
                    int num = in.nextInt();
                    String del = sb.substring(sb.length() - num);
                    sb.delete(sb.length() - num,sb.length());
                    stack.push(del);
                    stack.push(2+"");
                } else if (order == 3){
                    int index  = in.nextInt();
                    list.add(sb.charAt(index - 1));
                } else if (order == 4){
                    String backOrder = stack.pop();
                    String back = stack.pop();
                    if (backOrder.equals("1")){
                        sb.delete(sb.length() - back.length(),sb.length());
                    }
                    if (backOrder.equals("2")){
                        sb.append(back);
                    }
                }
            }
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
    */


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
    /*
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
     */
}

