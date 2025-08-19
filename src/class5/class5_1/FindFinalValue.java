package class5.class5_1;

public class FindFinalValue {
    public int findFinalValue(int[] nums, int original) {
        MyBitset set = new MyBitset(1000);
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original <<= 1;
        }
        return original;
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
