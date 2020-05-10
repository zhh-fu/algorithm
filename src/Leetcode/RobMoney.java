package Leetcode;

import BasicConstructure.TreeNode;

/**
 * 打家劫舍三部曲
 * 打家劫舍1：每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *           如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *           给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *           dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
 *
 * 打家劫舍2：这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 *           同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *          给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 解题思路：区别于 1 ，公式不变，但是由于是环形链表的形式，
 *          因此需要考虑两种情况 能取到第一间房和不能取到第一间房
 *          能取到第一间房，则取不到最后一间房，即取不到nums[n-1]
 *          不能取到第一间房，即从第二件开始，那么可以取到nums[n-1]
 *
 * 打家劫舍3：地区只有一个入口，我们称之为“根”。
 *          除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 *          一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 *          如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *          计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class RobMoney {
    //时间空间复杂度均为O(N)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //dp[i]表示经过有 i 间时房能偷到的最多钱
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=nums.length;i++){
            //当前房间的钱+上上个房间时的钱
            //与上个房间时的最多钱
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }

    //时间为O(N)，空间为O(1)
    //只需要记忆上一个房间的钱就行了
    public int rob_1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //cur为上一个房间时的钱数
        int cur = 0;
        //pre为上上个房间时的钱数
        int pre = 0;
        for(int curMoney : nums){
            int tmp = cur;
            //curMoney为当前房间的钱数
            cur = Math.max(pre + curMoney, cur);
            pre = tmp;
        }
        return cur;
    }

    //升级为环形链表，拆分为两个数组
    public static int rob_2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = dp2[0] = 0;
        //dp1代表能取到第一间房，dp1[1] = nums[0];
        dp1[1] = nums[0];
        //dp2代表不用能取到第一间房，dp2[1] = nums[1];
        dp2[1] = nums[1];
        for (int i=2;i<nums.length;i++){
            //递推公式不变，只有nums的下标变化了
            dp1[i] = Math.max(dp1[i-2] + nums[i-1], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }
        //返回两者较大值即可
        return Math.max(dp1[nums.length - 1],dp2[nums.length - 1]);
    }

    //升级为树，以一颗三层的满二叉树为一个计量单位
    //当前节点分为偷与不偷两种情况
    public int rob_3(TreeNode root) {
        if(root == null) return 0;
        int[] res = robMoney(root);
        //返回偷和不偷的最大值
        return Math.max(res[0],res[1]);
    }

    private int[] robMoney(TreeNode root){
        if(root == null) return new int[2];
        int money = root.val;

        //res[0] 代表当前节点不偷时有的钱
        //res[1] 代表当前节点偷时有的钱
        int[] res = new int[2];
        //左右孩子节点的情况
        int[] left = robMoney(root.left);
        int[] right = robMoney(root.right);
        //当前节点不偷，那么就是左右孩子的分别偷的钱的最大值加起来
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //当前节点偷，那么就是当前节点的钱加上左右孩子不偷的钱
        res[1] = money + left[0] + right[0];
        return res;
    }

    //树形的基础解法
    //我们使用爷爷、两个孩子、4 个孙子来说明问题
    //爷爷节点获取到最大的偷取的钱数呢
    //首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
    //二叉树只有左右两个孩子，一个爷爷最多 2 个儿子，4 个孙子
    //根据以上条件，我们可以得出单个节点的钱该怎么算
    //4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。
    // 这就是动态规划里面的最优子结构
    public int rob_4(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        //爷爷节点加上孙子节点，孙子节点为空时代表为0
        if (root.left != null) {
            money += (rob_4(root.left.left) + rob_4(root.left.right));
        }

        if (root.right != null) {
            money += (rob_4(root.right.left) + rob_4(root.right.right));
        }

        //爷爷+孙子节点的钱 VS 儿子节点的钱
        return Math.max(money, rob_4(root.left) + rob_4(root.right));
    }
}
