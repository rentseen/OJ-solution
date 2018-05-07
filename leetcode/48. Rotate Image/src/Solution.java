public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int depth = 0; depth<n/2; depth++) {
            for(int i=0; i<n-2*depth-1; i++) {
                int tmp = matrix[depth][depth+i];
                matrix[depth][depth+i] = matrix[n-1-depth-i][depth];
                matrix[n-1-depth-i][depth] = matrix[n-1-depth][n-1-depth-i];
                matrix[n-1-depth][n-1-depth-i] = matrix[depth+i][n-1-depth];
                matrix[depth+i][n-1-depth] = tmp;
            }
        }
    }
}
