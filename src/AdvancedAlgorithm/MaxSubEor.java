package AdvancedAlgorithm;

/**
 * 给定数组，求子数组的最大异或和。
 */
public class MaxSubEor {

    //暴力法，遍历三遍，时间复杂度为O(N3)
    public static int getMax1(int[] arr){
        int res = 0;
        //TODO
        return res;
    }

    //法二，使用异或运算性质来计算
    //eor3 = eor1 ^ eor2 => epr1 = eor2 ^ eor3
    public static int getMax2(int[] arr){
        if (arr.length == 0 || arr == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        //使用dp[]数组来记录从 0 ~ i 的异或结果
        int[] dp = new int[arr.length];
        int eor = 0;
        for (int i=0;i<arr.length;i++){
            eor ^= arr[i];
            //取max 和 到i的最大异或和
            max = Math.max(max, eor);
            for (int start = 1;start < i;start++){
                //求start ~ i 的异或和
                int eorIn = eor ^ dp[start - 1];
                max = Math.max(eorIn, max);
            }
            //存储到dp[]中
            dp[i] = eor;
        }
        return max;
    }

    //方法三 字典树，没有听懂
    public static class Node {
        //只有 0 和 1
        public Node[] nexts = new Node[2];
    }

    public static class NumTrie {
        public Node head = new Node();

        //往树里添加节点
        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                //取出每一位
                int path = ((num >> move) & 1); //1, 0
                //没有路径就新建，有就不变
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                //取出最高位
                int path = (num >> move) & 1;
                //期待选择的路
                //31符号位，希望和符号位一样，这样可以取正
                int best = move == 31 ? path : (path ^ 1);
                //我实际选的路，路径不为空，可以走，不变
                //没有路，只能走另外一条路，取反
                best = cur.nexts[best] != null ? best : (best ^ 1);
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }

    }

    public static int maxXorSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }
}
