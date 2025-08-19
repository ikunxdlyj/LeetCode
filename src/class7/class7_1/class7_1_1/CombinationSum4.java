package class7.class7_1.class7_1_1;

import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, nums, target, dp);
    }

    public int f(int i, int curSum, int[] nums, int target, int[][] dp) {
        if (i == nums.length) {
            return curSum == target ? 1 : 0;
        }
        if (curSum == target) {
            return 1;
        }
        if (curSum > target) {
            return 0;
        }
        if (dp[i][curSum] != -1) {
            return dp[i][curSum];
        }
        int p1 = f(i + 1, curSum, nums, target, dp);
        int p2 = f(0, curSum + nums[i], nums, target, dp);
        dp[i][curSum] = p1 + p2;
        return dp[i][curSum];
    }


}
