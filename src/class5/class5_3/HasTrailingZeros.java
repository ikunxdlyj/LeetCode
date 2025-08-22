package class5.class5_3;

public class HasTrailingZeros {
    public boolean hasTrailingZeros1(int[] nums) {
        int rightOne;
        int cnt = 0;
        for (int num : nums) {
            rightOne = num & (-num);
            if (rightOne == 1) {
                cnt++;
            }
        }
        return cnt < nums.length;
    }

    public boolean hasTrailingZeros2(int[] nums) {
        int even = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                even++;
            }
        }
        return even >= 2;
    }
}
