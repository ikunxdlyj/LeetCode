package class4.class4_2;

public class HasValidPath {
    public boolean hasValidPath(int[][] grid) {
        return f(0, 0, grid);
    }

    public boolean f(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return false;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        boolean ans;
        switch (temp) {
            case 1:
                ans = f(i, j - 1, grid) || f(i, j + 1, grid);
                grid[i][j] = temp;
                return ans;
            case 2:
                ans = f(i - 1, j, grid) || f(i + 1, j, grid);
                grid[i][j] = temp;
                return ans;
            case 3:
                ans = f(i, j - 1, grid) || f(i + 1, j, grid);
                grid[i][j] = temp;
                return ans;
            case 4:
                ans = f(i + 1, j, grid) || f(i, j + 1, grid);
                grid[i][j] = temp;
                return ans;
            case 5:
                ans = f(i, j - 1, grid) || f(i - 1, j, grid);
                grid[i][j] = temp;
                return ans;
            case 6:
                ans = f(i - 1, j, grid) || f(i, j + 1, grid);
                grid[i][j] = temp;
                return ans;
            default:
                return false;
        }
    }

}
