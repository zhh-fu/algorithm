package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //public static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> cur : output) {
                //因为当前元素肯定没有在集合中出现过
                //对当前集合中所有的list遍历一遍
                //所有list只要加入当前元素即可
                //因为新元素的存在使得得到的集合和原始集合必不一样
                List<Integer> subList = new ArrayList<>(cur);
                subList.add(num);
                newSubsets.add(subList);
                /*
                newSubsets.add(new ArrayList<Integer>(cur){
                    {
                        add(num);
                    }
                }
                );
                */
            }
            //更新后的集合加入到大集合中
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }
}
