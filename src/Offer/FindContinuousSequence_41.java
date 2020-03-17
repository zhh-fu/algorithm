package Offer;

import java.util.ArrayList;

/**
 * 和为sum的连续整数序列
 * 找出所有和为sum的连续正数序列
 * 输出描述:输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 解题思路1：窗口法，双指针滑动窗口，小了右移，大了左移，等于保存数据
 * 解题思路2：等差思想，序列必定是等差数列，数列长度为n，中间的数必定是sum/n
 *            n为奇数时，s/n必定是中间的数，且为正数才可
 *            n为偶数时，2s/n是中间两个数的和，如果s%n的余数就是n个0.5
 *
 *            所以判断依据为 sum%n*2 == n，而不是 2*sum % n == 0
 *            且假设数列从1开始到n为最长，那么n(n+1)/2 <= sum，那么 n < (2sum)^0.5
 *            时间复杂度为sum^0.5
 */
public class FindContinuousSequence_41 {
    private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    //窗口法
    public ArrayList<ArrayList<Integer>> findContinuousSequence_1(int sum) {
        if(sum < 3) return list;

        int p1 = 1,p2 = 2;
        //注意条件，双指针是不能相遇的且右指针超过sum的一半就不可能了
        while(p2 > p1 && p2 <= (sum/2+1)){
            //窗口内的数的和
            int cur = (p2 + p1)*(p2 - p1 + 1)/2;
            if(cur == sum){
                //这个地方必须重新构建
                ArrayList<Integer> subList = new ArrayList<Integer>();
                for(int i=p1;i<=p2;i++){
                    subList.add(i);

                }
                list.add(subList);
                //当前面满足后，左指针向右滑动
                p1++;
            } else if(cur < sum){
                p2++;
            } else{
                p1++;
            }
        }
        return list;
    }

    //纯数学的思想，等差数列的性质
    public ArrayList<ArrayList<Integer> > findContinuousSequence_2(int sum) {
        if(sum < 3) return list;
        //注意此处的起始值
        for(int n= (int) Math.sqrt(2*sum);n>=2;n--){
            //序列长度n为奇数时，sum/n必为中间值
            if((n % 2 == 1) && (sum % n == 0)){
                int mid = sum / n;
                ArrayList<Integer> subList = new ArrayList<Integer>();
                for(int i= mid - (int) n/2;i<= mid + (int) n/2;i++){
                    subList.add(i);
                }
                list.add(subList);
                //序列长度n为偶数时
                //序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，
                //所以条件为：(sum % n) * 2 == n.
            } else if((n % 2 == 0) && sum  % n * 2== n){
                int mid = sum / n;
                ArrayList<Integer> subList = new ArrayList<Integer>();
                for(int i= mid + 1 - n/2;i<= mid + n/2;i++){
                    subList.add(i);
                }
                list.add(subList);
            }

        }
        return list;
    }

    /*
    class listCompare implements Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2){
            return list1.get(0) - list2.get(0);
        }
    }
    */
}
