package class1.class1_2.class1_2_1.class1_2_1_1;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < fruits.length; l++, r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
