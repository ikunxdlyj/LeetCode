package class2.class2_1.class2_1_1;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            ones += num;
        }
        if (ones == 0) return 0;
        if (ones == nums.length) return nums.length - 1;

        // TODO
        return Integer.MIN_VALUE;
    }
}
