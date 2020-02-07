package AdvancedAlgorithm;

import java.util.HashMap;

public class MostXor {
    public static int mostEOR(int[] arr) {
        int ans = 0;
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            //找最晚出现相同xor的位置
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                // -1 代表开始，然后找到dp[k-1] + 1
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                //取两者中的最大值
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            //更新出现xor的最晚位置
            map.put(xor, i);
            //取两者中的最大值
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
