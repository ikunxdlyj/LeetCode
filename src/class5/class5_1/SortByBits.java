package class5.class5_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByBits {
    public static void main(String[] args) {
        int[] arr={2,5,6,7,12,15};
        int[] res=sortByBits(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] sortByBits(int[] arr) {
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i],countOne(arr[i])});
        }
        list.sort((a,b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
        int[] res=new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i)[0];
        }
        return res;
    }

    public static int countOne(int n) {
        int cnt = 0;
        int rightOne;
        while (n != 0) {
            cnt++;
            rightOne = n & (-n);
            n ^= rightOne;
        }
        return cnt;
    }
}
