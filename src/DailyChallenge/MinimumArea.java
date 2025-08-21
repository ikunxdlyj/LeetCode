package DailyChallenge;

public class MinimumArea {

    public int minimumArea(int[][] grid) {
        int left=Integer.MAX_VALUE,right=0;
        int top=Integer.MAX_VALUE,bottom=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    left=Math.min(left,i);
                    right=Math.max(right,i);
                    top=Math.min(top,j);
                    bottom=Math.max(bottom,j);
                }
            }
        }
        return (right-left+1)*(bottom-top+1);
    }
}
