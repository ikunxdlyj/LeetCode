package class5.class5_1;

public class FindKOr {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                cnt[i] += (((num >> i) & 1) == 1 ? 1 : 0);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
