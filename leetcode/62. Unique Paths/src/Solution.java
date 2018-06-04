public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] can = new int[m][n];
        for(int i=0; i<m; i++) {
            can[i][0]=1;
        }
        for(int i=0; i<n; i++) {
            can[0][i]=1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                can[i][j] = can[i-1][j]+can[i][j-1];
            }
        }
        return can[m-1][n-1];
    }
    public static void main(String[] args) {

    }
}
