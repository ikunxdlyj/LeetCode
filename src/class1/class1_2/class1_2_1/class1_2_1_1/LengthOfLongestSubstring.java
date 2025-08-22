package class1.class1_2.class1_2_1.class1_2_1_1;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] s = str.toCharArray();
        int[] cnt = new int[256];
        int ans = 0;
        for (int l = 0, r = 0; r < s.length; r++) {
            cnt[s[r]]++;
            while (cnt[s[r]] > 1) {
                cnt[s[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
