package class4.class4_1;

import java.util.Arrays;

public class MaxMoves {
    public static final int[][] move = {
            { -1, 1 },
            { 0, 1 },
            { 1, 1 }
    };

    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans, f(i, 0, grid, dp));
        }
        return ans;
    }

    public int f(int i, int j, int[][] grid, int[][] dp) {
        if (j == grid[0].length - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        for (int k = 0; k < 3; k++) {
            int nx = i + move[k][0], ny = j + move[k][1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] > grid[i][j]) {
                ans = Math.max(ans, 1 + f(nx, ny, grid, dp));
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
