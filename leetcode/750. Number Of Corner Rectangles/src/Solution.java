public class Solution {
    public int countCornerRectangles(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==0)
                    continue;
                for(int k=j+1; k<grid[i].length; k++){
                    if(grid[i][k]==0)
                        continue;
                    for(int m=i+1; m<grid.length; m++){
                        if(grid[m][j]==1 && grid[m][k]==1)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
