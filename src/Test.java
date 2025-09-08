public class Test {
    public static void main(String[] args) {

        System.out.println(Long.MAX_VALUE);
        System.out.println((long) 10e14);
    }

    public static int process(int n) {
        return f(0, n);
    }

    public static int f(int i, int n) {
        if (i == n) {
            return 1;
        }
        int p1 = 2 * f(i + 1, n);
        int p2 = 0;
        if (i + 1 < n) {
            p2 = 2 * f(i + 2, n);
        } else {
            p2 = f(i + 1, n);
        }
        return p1 + p2;
    }
}
