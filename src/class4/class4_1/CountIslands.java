package class4.class4_1;

public class CountIslands {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && dfs(i, j, grid) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        return val + dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j - 1, grid) + dfs(i, j + 1, grid);
    }
}
