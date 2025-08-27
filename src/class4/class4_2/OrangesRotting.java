package class4.class4_2;

public class OrangesRotting {
    public static int l, r, size, level;
    public static final int[][] move = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    public static int[][] queue = new int[11 * 11][2];

    public int orangesRotting(int[][] grid) {
        l = r = level = 0;
        int freshCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                } else if (grid[i][j] == 2) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                }
            }
        }
        while (l < r && freshCnt > 0) {
            level++;
            int curLevelSize = r - l;
            for (int i = 0; i < curLevelSize; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + move[j][0];
                    int ny = y + move[j][1];
                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshCnt--;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
        }
        return freshCnt > 0 ? -1 : level;
    }

}