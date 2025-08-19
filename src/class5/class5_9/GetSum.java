package class5.class5_9;

public class GetSum {
    public int getSum(int a, int b) {
        int xor = a ^ b, carry = (a & b) << 1;
        int temp;
        while (carry != 0) {
            temp = xor;
            xor ^= carry;
            carry = (temp & carry) << 1;
        }
        return xor;
    }
}
