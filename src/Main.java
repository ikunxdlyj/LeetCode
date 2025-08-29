import java.io.*;

public class Main {
    public static int a, b;
    public static char op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        // 设置操作符为普通字符，确保正确读取
        in.ordinaryChar('+');
        in.ordinaryChar('-');
        in.ordinaryChar('*');
        in.ordinaryChar('/');
        in.ordinaryChar('^');
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        in.nextToken();
        int N = (int) in.nval;
        for (int i = 0; i < N; i++) {
            in.nextToken();
            a = (int) in.nval;
            in.nextToken();
            b = (int) in.nval;
            in.nextToken();
            op = (char) in.ttype; // 直接获取操作符字符
            out.println(process());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static char process() {
        switch (op) {
            case '+':
            case '*':
                return '=';
            case '-':
                if (a == b) return '=';
                else if (a > b) return '>';
                else return '<';
            case '/':
                int div1 = a / b;
                int div2 = b / a;
                if (div1 == div2) return '=';
                else if (div1 > div2) return '>';
                else return '<';
            case '^':
                if (a == b) return '=';
                if (a == 1) return '<';
                if (b == 1) return '>';
                double loga = Math.log(a);
                double logb = Math.log(b);
                double left = b * loga;
                double right = a * logb;
                if (Math.abs(left - right) < 1e-10) {
                    return '=';
                } else if (left < right) {
                    return '<';
                } else {
                    return '>';
                }
            default:
                return '#'; // 不应发生
        }
    }
}