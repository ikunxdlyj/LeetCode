package class5.class5_1;

public class FindComplement {
    public int findComplement(int num) {
        int ans = 0;
        int highBit = 0;

        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                highBit = i;
                break;
            }
        }
        for (int i = highBit; i >= 0; i--) {
            ans = (ans << 1) + (((num >> i) & 1) == 1 ? 0 : 1);
        }
        return ans;
    }
}
