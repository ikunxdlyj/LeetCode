package class4.class4_2;

public class HighestPeak {
    public static int[][] queue = new int[1001 * 1001][2];
    public static int l, r, level;
    public static final int[][] move = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    public int[][] highestPeak(int[][] isWater) {
        l = r = level = 0;
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = -1;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                }
            }
        }
        while (l < r) {
            level++;
            int curLevelSize = r - l;
            for (int i = 0; i < curLevelSize; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + move[j][0];
                    int ny = y + move[j][1];
                    if (nx >= 0 && ny >= 0 && nx < isWater.length && ny < isWater[0].length && isWater[nx][ny] == 0) {
                        isWater[nx][ny] = level;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
        }
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == -1) {
                    isWater[i][j] = 0;
                }
            }
        }
        return isWater;
    }
}
