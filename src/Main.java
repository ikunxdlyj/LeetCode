import java.io.*;
import java.util.Arrays;

public class Main {
    public static int N;
    public static int[] arr = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (int) in.nval;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(process());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int[] cnt = new int[101];

    public static long process() {
        Arrays.fill(cnt, 0);
        for (int i = 0; i < N; i++) {
            cnt[arr[i]]++;
        }
        return f(0, 1);
    }

    public static long f(int i, int last) {
        if (i == N) {
            return 1;
        }
        long ans = 0;
        for (int j = 1; j <= 100; j++) {
            if (cnt[j] > 0 && (j % last == 0 || last % j == 0)) {
                cnt[j]--;
                // 数值相同的j并不能只看成一个，所以我们要利用乘法原理，乘以j的数量
                ans += (cnt[j] + 1) * f(i + 1, j);
                cnt[j]++;
            }
        }
        return ans;
    }

}