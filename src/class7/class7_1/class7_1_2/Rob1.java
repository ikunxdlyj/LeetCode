package class7.class7_1.class7_1_2;

import java.util.Arrays;

public class Rob1 {
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }

    public int f(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int p1 = f(i + 1, nums, dp);
        int p2 = nums[i] + f(i + 2, nums, dp);
        dp[i] = Math.max(p1, p2);
        return dp[i];
    }

    public int rob2(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            int p1 = dp[i + 1];
            int p2 = nums[i] + dp[i + 2];
            dp[i] = Math.max(p1, p2);
        }
        return dp[0];
    }

    // cur   next    nextNext
    // next nextNext
    public int rob3(int[] nums) {
        int next = 0, nextNext = 0;
        int cur;
        for (int i = nums.length - 1; i >= 0; i--) {
            int p1 = next;
            int p2 = nums[i] + nextNext;
            cur = Math.max(p1, p2);
            nextNext = next;
            next = cur;
        }
        return next;
    }

    public int rob4(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return g(0, false, nums, dp);
    }

    public int g(int i, boolean lastRob, int[] nums, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i][lastRob ? 1 : 0] != -1) {
            return dp[i][lastRob ? 1 : 0];
        }
        // last cur next
        //   F
        //   T
        if (lastRob) {
            dp[i][1] = g(i + 1, false, nums, dp);
            return dp[i][1];
        } else {
            int p1 = g(i + 1, false, nums, dp);
            int p2 = nums[i] + g(i + 1, true, nums, dp);
            dp[i][0] = Math.max(p1, p2);
            return dp[i][0];
        }

    }

}
