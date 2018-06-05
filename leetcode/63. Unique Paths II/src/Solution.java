public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] can = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length && obstacleGrid[i][0]!=1; i++) {
            can[i][0]=1;
        }
        for(int i=0; i<obstacleGrid[0].length && obstacleGrid[0][i]!=1; i++) {
            can[0][i]=1;
        }
        for(int i=1; i<obstacleGrid.length; i++) {
            for(int j=1; j<obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]!=1) {
                    can[i][j] = can[i-1][j]+can[i][j-1];
                }
            }
        }
        return can[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
