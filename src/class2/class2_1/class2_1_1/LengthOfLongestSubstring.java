package class2.class2_1.class2_1_1;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring1(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] s = str.toCharArray();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int ans = 1;
        for (int l = 0, r = 0; r < s.length; r++) {
            l = Math.max(l, last[s[r]] + 1);
            ans = Math.max(ans, r - l + 1);
            last[s[r]] = r;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] s = str.toCharArray();
        int[] cnt = new int[256];
        int ans = 1;
        for (int l = 0, r = 0; r < s.length; r++) {
            cnt[s[r]]++;
            while (cnt[s[r]] > 1) {
                // 注意下面两句代码的执行顺序，如果先l++，那么cnt[s[l]]--执行的就是加一之后的位置，不是原来的l;
                cnt[s[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
