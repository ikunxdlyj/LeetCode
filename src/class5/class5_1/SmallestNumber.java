package class5.class5_1;

public class SmallestNumber {
    public int smallestNumber(int n) {
        int bit = 0;
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                bit = i;
                break;
            }
        }
        return (1 << (bit + 1)) - 1;
    }
}
