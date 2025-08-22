package class4.class4_2;

public class OrangesRotting {
    public static int[][] queue = new int[101][2];
    public static int l, r, size, level;
    public static final int[][] move = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        l = r = size = level = 0;
        int freshCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCnt++;
                }
                if (grid[i][j] == 2) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    size++;
                }
            }
        }
        while (l < r) {
            level++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue[l++];
                size--;
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + move[j][0];
                    int ny = cur[1] + move[j][1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshCnt--;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                        size++;
                    }
                }
            }
        }
        return freshCnt > 0 ? -1 : level;
    }
}
