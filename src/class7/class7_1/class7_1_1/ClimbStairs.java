package class7.class7_1.class7_1_1;

import java.util.Arrays;

public class ClimbStairs {
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    public int f(int i, int[] dp) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = f(i - 1, dp) + f(i - 2, dp);
        return dp[i];
    }

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prePre = 1, pre = 2, cur;
        for (int i = 3; i <= n; i++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }
        return pre;
    }

//    public int climbStairs5(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//
//    }
}
