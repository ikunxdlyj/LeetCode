package class5.class5_9;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int xor1 = 0;
        for (int num : nums) {
            xor1 ^= num;
        }
        int xor2 = 0;
        int rightOne = xor1 & (-xor1);
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                xor2 ^= num;
            }
        }
        return new int[]{xor2, xor1 ^ xor2};
    }
}
