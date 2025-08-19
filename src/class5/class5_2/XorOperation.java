package class5.class5_2;

public class XorOperation {

    public static int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = start + (i << 1);
        }
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}
