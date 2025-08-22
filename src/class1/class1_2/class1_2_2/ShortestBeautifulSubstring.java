package class1.class1_2.class1_2_2;

public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String str, int k) {
        int cnt = 0;
        char[] s = str.toCharArray();
        int len = Integer.MAX_VALUE;
        String ans = "";
        for (int l = 0, r = 0; r < s.length; r++) {
            cnt += s[r] - '0';
            while (cnt > k) {
                cnt -= s[l++] - '0';
            }
            if (cnt == k) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ans = str.substring(l, r + 1);
                } else if (r - l + 1 == len) {
                    ans = ans.compareTo(str.substring(l, r + 1)) < 0 ? ans : str.substring(l, r + 1);
                }
            }
        }
        return ans;
    }
}
