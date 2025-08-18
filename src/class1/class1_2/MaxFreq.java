package class1.class1_2;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
//    题目中有一个关键性质：如果一个子串S（长度为L）出现多次，那么它的任意子串（特别是长度为minSize的子串）也会出现至少同样多次（因为S出现的地方，它的长度为minSize的前缀一定出现）。
//    因此，实际上我们只需要考虑长度为minSize的子串即可。为什么？
//    - 因为如果一个长度为L（L>minSize）的子串满足条件，那么它的一个长度为minSize的前缀（或任意位置的长度为minSize的子串）一定也满足条件（因为不同字母数只会更少，不会超过maxLetters）。
//      而且，这个长度为minSize的子串出现的次数一定不少于长度为L的子串（因为每次出现这个长串时，它的前缀也出现）。
//     - 因此，最大出现次数的子串，一定可以在长度为minSize的子串中找到。
//    所以，我们只需要考虑长度为minSize的子串，而不需要遍历minSize到maxSize。这样，问题就简化为：

//    在字符串s中，找出所有长度为minSize的子串，要求该子串中不同字符数<=maxLetters，然后统计每个这样的子串出现的次数，最后返回这些次数中的最大值（如果没有满足条件的子串，则返回0）。

    public int maxFreq(String str, int maxLetters, int minSize, int maxSize) {
        char[] s = str.toCharArray();
        int[] map = new int[26];
        Map<String, Integer> freqMap = new HashMap<>();
        // f函数只调用minSize这一次即可，因为它是最短的，别的更长的都会以它为前缀，它满足，更长的更会满足
        f(s, str, maxLetters, minSize, map, freqMap);
        int ans = 0;
        for (String string : freqMap.keySet()) {
            ans = Math.max(ans, freqMap.get(string));
        }
        return ans;
    }

    public void f(char[] s, String str, int maxLetters, int len, int[] map, Map<String, Integer> freqMap) {
        int diffChar = 0;
        String sub;
        for (int i = 0; i < s.length; i++) {
            if (map[s[i] - 'a']++ == 0) {
                diffChar++;
            }
            if (i < len - 1) {
                continue;
            }
            if (diffChar <= maxLetters) {
                sub = str.substring(i - len + 1, i + 1);
                freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
            }
            if (--map[s[i - len + 1] - 'a'] == 0) {
                diffChar--;
            }
        }
    }
}
