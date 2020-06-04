package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class MergeMatrix {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return  list.toArray(new int[0][]);
        int i=0;
        //对左边界进行排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        while(i < intervals.length){
            int left = intervals[i][0], right = intervals[i][1];
            //左边界必定是连续的，左边界小于等于当前的有边界则可以合并
            while(i + 1 < intervals.length && intervals[i + 1][0] <= right){
                //更新有边界
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        //这个返回是IDEA给的，不太清楚为什么可以这样
        return  list.toArray(new int[0][]);
    }
}
