package Offer;

/**
 * 连续子数组的最大和
 * 计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？
 * (子向量的长度至少是1)
 *
 * 解题思路1：求得数组最大值（防止全为负数的情况），然后求连续子数组的最大值
 *              在这个过程中更新最大和即可。
 * 解题思路2：动态规划 ，dp[i]表示以位置i结尾的连续子数组的最大和。
 *            没有使用dp数组，减小空间复杂度
 *            第i个位置结尾的子数组的最大和是前一个位置结尾的数组的最大和加上当前位置的和
 *            与当前位置的较大值，即dp[i+1] = Math.max(dp[i]+array[i], array[i]);
 */
public class FindGreatestSumOfSubArray_30 {
    //常规思路
    public int findGreatestSumOfSubArray_1(int[] array) {
        if(array == null || array.length == 0) return 0;
        int sum = 0;
        //先确定整个数组的最大值
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
            }
        }

        for(int i=0;i<array.length;i++){
            //如果在和为零的时候，当前值小于零得到的sum则必不可能是最大值
            //直接进行下一次循环
            if(sum ==0 && array[i] <= 0){
                continue;
            } else{
                //如果当前sum+array[i] > 0 仍有机会成为最大值
                if(sum + array[i] > 0){
                    sum += array[i];
                    //sum变更一次，就更新一次最大值
                    if(sum > max){
                        max = sum;
                    }
                } else{
                    //否则的话将sum置零
                    sum = 0;
                }
            }
        }
        return max;
    }

    //动态规划，只不过没有设置dp[]，避免提升空间复杂度
    public int findGreatestSumOfSubArray_2(int[] array) {
        if(array == null || array.length == 0) return 0;
        int res = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            //max 是以当前位置结尾的子数组的最大和
            //res 是当前的子数组的最大和
            max = Math.max(max+array[i],array[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}
