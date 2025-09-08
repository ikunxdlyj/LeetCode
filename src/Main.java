import java.io.*;

public class Main {
    public static int N;
    public static int[] cost = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (int) in.nval;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                cost[i] = (int) in.nval;
            }
            out.println(process());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int process() {

    }

    public static int f(int i,)


}