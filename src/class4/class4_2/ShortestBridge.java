package class4.class4_2;

public class ShortestBridge {
    public static final int[][] moves = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    public static int[][] queue = new int[100 * 100 + 1][2];
    public static int l, r, level;

    // 只从第一个岛开始，不需要两个岛同时扩展，最后×2
    // 如果两个岛的距离为奇数,×2的做法显然不正确
    public int shortestBridge(int[][] grid) {

        // 将遇到的第一座岛改成 2号岛，然后break，剩下的那座岛还是原来的 1
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    infect(i, j, grid);
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        l = r = level = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue[r][0] = i;
                    queue[r++][1] = j;
                }
            }
        }
        while (l < r) {
            level++;
            int size = r - l;
            for (int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int[] move : moves) {
                    int nx = x + move[0];
                    int ny = y + move[1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != 1) {
                        if (grid[nx][ny] == 0) {
                            grid[nx][ny] = 1;
                            queue[r][0] = nx;
                            queue[r++][1] = ny;
                        } else {
                            return level - 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void infect(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        for (int[] move : moves) {
            infect(i + move[0], j + move[1], grid);
        }
    }

}