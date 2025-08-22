package class1.class1_2.class1_2_1.class1_2_1_1;

public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String str) {
        char[] s = str.toCharArray();
        int[] cnt = new int[26];
        int ans = 0;
        for (int l = 0, r = 0; r < s.length; r++) {
            cnt[s[r] - 'a']++;
            while (cnt[s[r] - 'a'] > 2) {
                cnt[s[l] - 'a']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
