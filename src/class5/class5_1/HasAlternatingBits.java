package class5.class5_1;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int highBit = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1) {
                highBit = i;
                break;
            }
        }
        for (int i = 1; i <= highBit; i++) {
            if (((n >> i & 1) ^ (n >> (i - 1) & 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
