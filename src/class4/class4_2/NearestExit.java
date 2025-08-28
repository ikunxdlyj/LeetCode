package class4.class4_2;

public class NearestExit {
    public static final int[][] moves = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    public static int[][] queue = new int[10001][2];
    public static int l, r, level;

    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze[entrance[0]][entrance[1]] == '+') {
            return -1;
        }
        l = r = level = 0;
        maze[entrance[0]][entrance[1]] = '#';
        queue[r][0] = entrance[0];
        queue[r++][1] = entrance[1];
        while (l < r) {
            level++;
            int size = r - l;
            for (int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int[] move : moves) {
                    int nx = x + move[0];
                    int ny = y + move[1];
                    if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == '.') {
                        if ((nx == 0 || nx == maze.length - 1 || ny == 0 || ny == maze[0].length - 1)) {
                            return level;
                        }
                        maze[nx][ny] = '#';
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
        }
        return -1;
    }
}