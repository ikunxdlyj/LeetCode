package class4.class4_1;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {
    public static final int[][] moves = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {-1, 1},
            {1, -1},
            {-1, -1}
    };

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(i, j, land));
                }
            }
        }
        list.sort((a,b)->a-b);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 0) {
            return 0;
        }
        grid[i][j] = -1;
        int area = 1;
        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            area += dfs(x, y, grid);
        }
        return area;
    }
}

