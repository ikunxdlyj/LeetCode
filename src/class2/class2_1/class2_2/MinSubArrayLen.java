package class2.class2_1.class2_2;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum - nums[l] >= target) {
                sum -= nums[l++];
            }
            if(sum>=target){
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
