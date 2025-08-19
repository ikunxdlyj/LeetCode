package class5.class5_9;

public class FindErrorNums {
    public static int[] res = new int[2];

    public int[] findErrorNums(int[] nums) {
        MyBitset set = new MyBitset(nums.length);
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                res[0] = num;
                break;
            }
        }
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
        res[1] = xor ^ res[0];
        return res;

    }

    public static class MyBitset {
        public int size;
        public int[] set;

        public MyBitset(int n) {
            size = n;
            set = new int[(n + 31) / 32];
        }

        public void add(int num) {
            set[num / 32] |= (1 << (num % 32));
        }

        public void remove(int num) {
            set[num / 32] &= ~(1 << (num % 32));
        }

        public boolean contains(int num) {
            return ((set[num / 32] >> (num % 32)) & 1) == 1;
        }
    }

}
