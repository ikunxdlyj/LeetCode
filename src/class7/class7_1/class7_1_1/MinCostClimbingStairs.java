package class7.class7_1.class7_1_1;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return f(cost.length, cost, dp);
    }

    public int f(int i, int[] cost, int[] dp) {
        if (i <= 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        // 从i-1来到当前位置，需要cost[i-1]代价，以及f(i-1)的代价
        int p1 = cost[i - 1] + f(i - 1, cost, dp);
        int p2 = cost[i - 2] + f(i - 2, cost, dp);
        dp[i] = Math.min(p1, p2);
        return dp[i];
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length <= 1) return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int p1 = cost[i - 1] + dp[i - 1];
            int p2 = cost[i - 2] + dp[i - 2];
            dp[i] = Math.min(p1, p2);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs3(int[] cost) {
        if (cost.length <= 1) return 0;
        int pre = 0, prePre = 0, cur;
        for (int i = 2; i <= cost.length; i++) {
            int p1 = pre + cost[i - 1];
            int p2 = prePre + cost[i - 2];
            cur = Math.min(p1, p2);
            prePre = pre;
            pre = cur;
        }
        return pre;
    }
}
