package class8.class8_1.class8_1_5;


public class MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2;
        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i + firstLen - 1 < n; i++) {
            for (int j = i + firstLen; j + secondLen - 1 < n; j++) {
                int firstSum = sum[i + firstLen - 1] - sum[i] + nums[i];
                int secondSum = sum[j + secondLen - 1] - sum[j] + nums[j];
                ans = Math.max(ans, firstSum + secondSum);
            }
        }
        for (int i = 0; i + secondLen - 1 < n; i++) {
            for (int j = i + secondLen; j + firstLen - 1 < n; j++) {
                int firstSum = sum[i + secondLen - 1] - sum[i] + nums[i];
                int secondSum = sum[j + firstLen - 1] - sum[j] + nums[j];
                ans = Math.max(ans, firstSum + secondSum);
            }
        }
        return ans;
    }
}
