package class1.class1_2;

public class MinSwaps {
    // 所有的定长窗口问题,注意窗口长度为0的情况,这时候当 i=nums.length-1的时候,i - len + 1 等于 n,数组越界
    public int minSwaps(int[] nums) {
        int onesAll = 0;
        for (int num : nums) {
            onesAll += num;
        }
        if (onesAll == 0 || onesAll == nums.length) {
            return 0;
        }
        return Math.min(f(nums, onesAll), g(nums, nums.length - onesAll));
    }

    // 所有的1放中间，0在两边
    public int f(int[] nums, int len) {
        int ans = Integer.MAX_VALUE;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            ones += nums[i];
            if (i < len - 1) {
                continue;
            }

            ans = Math.min(ans, len - ones);
            ones -= nums[i - len + 1];
        }
        return ans;
    }

    // 所有的1放两边,0放中间
    public int g(int[] nums, int len) {
        int ans = Integer.MAX_VALUE;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            ones += nums[i];
            if (i < len - 1) {
                continue;
            }
            ans = Math.min(ans, ones);
            ones -= nums[i - len + 1];
        }
        return ans;
    }
}
