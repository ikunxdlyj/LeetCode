import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int N, target;
    public static int[] arr = new int[100001];
    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (int) in.nval;
            in.nextToken();
            target = (int) in.nval;
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

    public static long process() {
        map = new HashMap<Integer, Integer>();
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            cnt += arr[i] * 2 == target ? 0 : map.getOrDefault(target - arr[i], 0);

        }
        cnt <<= 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] * 2 == target) {
                cnt++;
            }
        }
        return cnt;
    }


}