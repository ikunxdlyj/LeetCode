package class7.class7_7.class7_7_1;

import java.util.Arrays;

public class MinimumCoins {
    // i   i+i-1
    public int minimumCoins1(int[] prices) {
        int[][] dp = new int[prices.length + 1][prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, prices, dp);
    }

    public int f(int i, int freeBound, int[] prices, int[][] dp) {
        if (i == prices.length) {
            return 0;
        }
        if (freeBound >= prices.length) {
            return 0;
        }
        if (dp[i][freeBound] != -1) return dp[i][freeBound];
        int ans = prices[i] + f(i + 1, Math.max(2, i + i + 2), prices, dp);
        if (i < freeBound) {
            ans = Math.min(ans, f(i + 1, freeBound, prices, dp));
        }
        dp[i][freeBound] = ans;
        return ans;
    }

    public int minimumCoins2(int[] prices) {
        int[][] dp = new int[prices.length + 1][prices.length + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = prices.length - 1; j >= 0; j--) {
                dp[i][j] = prices[i] + getValue(i + 1, Math.max(2, i + i + 2), dp);
                if (i < j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public int getValue(int i, int j, int[][] dp) {
        if (i >= dp.length || j >= dp[0].length) {
            return 0;
        }
        return dp[i][j];
    }


}
