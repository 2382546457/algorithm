package com.xiaohe.动态规划.三步问题;


/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 */
class Solution {
    /**
     * 状态表示: dp[i] : 到达i位置时有多少种上楼梯的方式
     * 状态转移方程 :
     *      - 上一次走一步: dp[i] = dp[i-1]
     *      - 上一次走两步: dp[i] = dp[i-2]
     *      - 上一次走三步: dp[i] = dp[i-3]
     *      故状态转移方程为: dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
     *      而且取值可能很大，我们每两个数相加时都 % 1000000007
     */
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1]+dp[i-2]) % 1000000007 + dp[i-3]) % 1000000007;
        }
        return dp[n];
    }
}