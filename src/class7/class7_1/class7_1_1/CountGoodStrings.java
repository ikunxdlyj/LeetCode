package class7.class7_1.class7_1_1;

import java.util.Arrays;

public class CountGoodStrings {
    public static final int MOD = 1000000007;

    public int countGoodStrings1(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return f(0, low, high, zero, one, dp);
    }

    public int f(int len, int low, int high, int zero, int one, int[] dp) {
        if (len > high) {
            return 0;
        }
        if (dp[len] != -1) {
            return dp[len];
        }
        if (len < low) {
            int p1 = f(len + zero, low, high, zero, one, dp) % MOD;
            int p2 = f(len + one, low, high, zero, one, dp) % MOD;
            dp[len] = (p1 + p2) % MOD;
            return dp[len];
        }
        int p1 = f(len + zero, low, high, zero, one, dp) % MOD;
        int p2 = f(len + one, low, high, zero, one, dp) % MOD;
        dp[len] = (1 + p1 + p2) % MOD;
        return dp[len];
    }

    public int countGoodStrings2(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[high] = 1;
        for (int i = high - 1; i >= low; i--) {
            int p1 = getValue(i + zero, dp) % MOD;
            int p2 = getValue(i + one, dp) % MOD;
            dp[i] = (1 + p1 + p2) % MOD;
        }
        for (int i = low - 1; i >= 0; i--) {
            int p1 = getValue(i + zero, dp) % MOD;
            int p2 = getValue(i + one, dp) % MOD;
            dp[i] = (p1 + p2) % MOD;
        }
        return dp[0];
    }

    public int getValue(int i, int[] dp) {
        if (i >= dp.length) {
            return 0;
        }
        return dp[i];
    }
}
