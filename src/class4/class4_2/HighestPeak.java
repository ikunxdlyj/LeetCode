package class4.class4_2;

public class HighestPeak {
    public static int[] queue = new int[1001 * 1001];
    public static int l, r, level;
    public static final int[][] move = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

//    public int[][] highestPeak(int[][] isWater) {
//        int[][] res = new int[isWater.length][isWater[0].length];
//        l = r = 0;
//        level = 0;
//        for (int i = 0; i < isWater.length; i++) {
//            for (int j = 0; j < isWater[0].length; j++) {
//                if (isWater[i][j] == 1) {
//                    queue[r++] = 0;
//                }
//            }
//        }
//        while (l < r) {
//
//        }
//    }
}
