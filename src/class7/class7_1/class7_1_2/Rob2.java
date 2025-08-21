package class7.class7_1.class7_1_2;

public class Rob2 {


    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
    }

    // 198. 打家劫舍
    private int rob1(int[] nums, int start, int end) { // [start,end) 左闭右开
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i < end; i++) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

//
//    public int rob1(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return Math.max(f(0, nums.length - 2, nums, dp), f(1, nums.length - 1, nums, dp));
//    }
//
//    // 0 1 2        n-1
//    //
//    public int f(int l, int r, int[] nums, int[][] dp) {
//        if (l > r) {
//            return 0;
//        }
//        if (l == r) {
//            return nums[l];
//        }
//        if (l + 1 == r) {
//            return Math.max(nums[l], nums[r]);
//        }
//        if (dp[l][r] != -1) {
//            return dp[l][r];
//        }
//        int p1 = f(l + 1, r, nums, dp);
//        int p2 = nums[l] + f(l + 2, r, nums, dp);
//        dp[l][r] = Math.max(p1, p2);
//        return dp[l][r];
//    }


}
