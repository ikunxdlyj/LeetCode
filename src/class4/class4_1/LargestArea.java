package class4.class4_1;

public class LargestArea {
    public int largestArea(String[] grid) {
        char[][] arr = build(grid);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '0') {
                    dfs(i, j, arr, '0');
                }
            }
        }
        for (int j = 0; j < arr[0].length; j++) {
            dfs(0, j, arr, arr[0][j]);
            dfs(arr.length - 1, j, arr, arr[arr.length - 1][j]);
        }
        for (int i = 1; i < grid.length - 1; i++) {
            dfs(i, 0, arr, arr[i][0]);
            dfs(i, arr[0].length - 1, arr, arr[i][arr[0].length - 1]);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != '#') {
                    ans = Math.max(ans, dfs(i, j, arr, arr[i][j]));
                }
            }
        }
        return ans;
    }

    public char[][] build(String[] grid) {
        char[][] res = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            res[i] = grid[i].toCharArray();
        }
        return res;
    }

    public int dfs(int i, int j, char[][] grid, char std) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != std) {
            return 0;
        }
        grid[i][j] = '#';
        return 1 + dfs(i - 1, j, grid, std) + dfs(i + 1, j, grid, std) + dfs(i, j - 1, grid, std) + dfs(i, j + 1, grid, std);
    }
}