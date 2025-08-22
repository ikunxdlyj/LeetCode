package class1.class1_3.class1_3_1;

public class ReverseSubmatrix {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < (k>>1); i++) {
            for(int j=0;j<k;j++){
                swap(x+i,y+j,x+k-i,y+k-j,grid);
            }
        }
        return grid;
    }

    public void swap(int a, int b, int c, int d, int[][] grid) {
        int temp = grid[a][b];
        grid[a][b] = grid[c][d];
        grid[c][d] = temp;
    }
}
