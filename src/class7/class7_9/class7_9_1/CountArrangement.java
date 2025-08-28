package class7.class7_9.class7_9_1;

public class CountArrangement {
    public int countArrangement(int n) {
        return f(1, n, 0);
    }

    public int f(int i, int n, int visited) {
        if (i == n + 1) {
            return 1;
        }
        int ans = 0;
        for (int j = 1; j <= n; j++) {
            if (((visited >> j) & 1) == 0 && (i % j == 0 || j % i == 0)) {
                visited |= 1 << j;
                ans += f(i + 1, n, visited);
                visited &= ~(1 << j);
            }
        }
        return ans;
    }
}
