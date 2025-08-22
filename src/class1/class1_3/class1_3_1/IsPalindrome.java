package class1.class1_3.class1_3_1;

public class IsPalindrome {

    public boolean isPalindrome(String str) {
        char[] s = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - 'A' + 'a'));
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        str = sb.toString();
        s = str.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
