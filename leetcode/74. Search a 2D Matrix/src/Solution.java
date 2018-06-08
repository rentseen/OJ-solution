public class Solution {
    public boolean bs(int[][]matrix, int target, int low, int high) {
        if(low>high)
            return false;
        int mid = low + (high-low)/2;
        int row = mid/matrix[0].length;
        int col = mid%matrix[0].length;
        int k = matrix[row][col];
        if(k==target)
            return true;
        else if(k>target)
            return bs(matrix, target, low, mid-1);
        else
            return bs(matrix, target, mid+1, high);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        return bs(matrix, target, 0, matrix.length*matrix[0].length-1);
    }
}
