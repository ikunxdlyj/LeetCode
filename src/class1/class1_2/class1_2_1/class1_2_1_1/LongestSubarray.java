package class1.class1_2.class1_2_1.class1_2_1_1;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int cntZero = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            cntZero += 1 - nums[r];
            // cntZero+=1^nums[r];
            while (cntZero > 1) {
                // cntZero-=1^nums[l];
                cntZero -= 1 - nums[l];
                l++;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
