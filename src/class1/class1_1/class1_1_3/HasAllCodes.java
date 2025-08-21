package class1.class1_1.class1_1_3;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {

    // 1 2 3 4 5 6
    //   2 3 4
    //   3 4 5

    public boolean hasAllCodes1(String str, int k) {
        if (str.length() - k + 1 < k) {
            return false;
        }
        char[] s = str.toCharArray();
        int offset = 1 << (k - 1);
        Set<Integer> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < s.length; i++) {
            num = (num % offset) * 2 + s[i] - '0';
            if (i < k - 1) {
                continue;
            }
            set.add(num);
        }
        return set.size() == (1 << k);
    }

    public boolean hasAllCodes2(String str, int k) {
        int total = 1 << k;
        if (str.length() - k + 1 < total) {
            return false;
        }
        char[] s = str.toCharArray();
        int mask = (1 << k) - 1;
        boolean[] set = new boolean[total];
        int num = 0;
        int size = 0;
        for (int i = 0; i < s.length; i++) {
            num = ((num << 1) & mask) + s[i] - '0';
            if (i < k - 1) {
                continue;
            }
            if (!set[num]) {
                set[num] = true;
                size++;
            }
            if (size == total) {
                return true;
            }
        }
        return size == total;
    }

}
