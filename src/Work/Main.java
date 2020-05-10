package Work;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            ArrayList<Integer> list = new ArrayList<>();
            int p1 = 0, p2 = arr.length - 1;
            while (p1 != n - 1){
                if (arr[p2] - arr[p1] <= 5){
                    while (p2 != p1){
                        list.add(arr[p1]);
                        list.add(arr[p2]);
                        p2--;
                    }
                    p1++;
                    p2 = arr.length - 1;
                } else {
                    p2--;
                }
            }

            for (int i=0;i<list.size();i=i+2){
                System.out.println(list.get(i) + " " + list.get(i+1));
            }
        }
    }


    /*
    任意一个数字，排序，找出每两个之间的。
     */

    public static String getTelnum(String phone) {
        if (phone == null || phone.length() < 18)
            return null;
        Pattern pattern = Pattern.compile("1([0-9])\\d{9}$*");
        Matcher matcher = pattern.matcher(phone);
        StringBuffer bf = new StringBuffer();
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }

    public static String getTelnum_2(String phone){
        if (phone == null || phone.length() < 18)
            return null;
        return phone.substring(0,11);
    }


    /*
    public static void main(String[] args) {
        System.out.println(getTelnum_2("13259941226@198.cn"));
    }
    */


}

