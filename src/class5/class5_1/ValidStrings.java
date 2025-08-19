package class5.class5_1;

import java.util.ArrayList;
import java.util.List;

public class ValidStrings {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<String>();
        boolean flag;
        for (int i = 0; i < (1 << n); i++) {
            flag = true;
            for (int j = 1; j < n; j++) {
                if ((((i >> j) & 1) | ((i >> (j - 1)) & 1)) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(binaryOfNum(i, n));
            }
        }
        return list;
    }

    public String binaryOfNum(int num, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append((num >> i) & 1);
        }
        return sb.toString();
    }

}
