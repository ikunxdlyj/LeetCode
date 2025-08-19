import java.io.*;

public class Main {
    public static int v, n;
    public static int[] arr = new int[20001];
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            v = (int) in.nval;
            in.nextToken();
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(v - process());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int process() {
        dp = new int[n + 1][v + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                dp[i][j] = -1;
            }
        }
        return f(0, 0);
    }

    public static int f(int i, int cur) {
        if (i == n) {
            return 0;
        }
        if (dp[i][cur] != -1) {
            return dp[i][cur];
        }
        int p1 = f(i + 1, cur);
        int p2 = 0;
        if (cur + arr[i] <= v) {
            p2 = arr[i] + f(i + 1, cur + arr[i]);
        }
        dp[i][cur] = Math.max(p1, p2);
        return dp[i][cur];
    }
}