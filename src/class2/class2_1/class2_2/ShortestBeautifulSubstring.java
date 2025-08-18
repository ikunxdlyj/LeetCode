package class2.class2_1.class2_2;

import java.util.PriorityQueue;

public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String str, int k) {
        char[] s = str.toCharArray();
        PriorityQueue<String> heap = new PriorityQueue<>();
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length; r++) {
            sum += s[r] - '0';
            while (sum - (s[l] - '0') > k) {
                sum -= s[l] - '0';
                l++;
            }
            if (sum == k) {
                ans = Math.min(ans, r - l + 1);
                heap.add(str.substring(l, r + 1));
            }
        }
        if (heap.isEmpty()) {
            return "";
        }
        PriorityQueue<String> collect=new PriorityQueue<>();
        while (!heap.isEmpty()) {
            String peek = heap.poll();
            if (peek.length() == k) {
                collect.add(peek);
            }
        }
        return collect.poll();
    }
}
