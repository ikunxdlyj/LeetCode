package class1.class1_1.class1_1_1;

import java.util.Arrays;

public class GetAverages {
    public int[] getAverages1(int[] nums, int k) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length) {
                ans[i] = -1;
            } else {
                ans[i] = (int) ((sum[i + k] - sum[i - k] + nums[i - k]) / (2 * k + 1));
            }
        }
        return ans;
    }


    public int[] getAverages2(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < 2 * k) {
                continue;
            }
            ans[i - k] =(int) (sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }
        return ans;
    }

}
