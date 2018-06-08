public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean top = false;
        boolean left = false;
        boolean bottom = false;
        boolean right = false;
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[0][i]==0) {
                top=true;
                break;
            }
        }
        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[matrix.length-1][i]==0) {
                bottom=true;
                break;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0]==0) {
                left=true;
                break;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][matrix[0].length-1]==0) {
                right=true;
                break;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1; i<matrix.length-1; i++) {
            if(matrix[i][0]==0) {
                for(int j=0; j<matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=1; i<matrix[0].length-1; i++) {
            if(matrix[0][i]==0) {
                for(int j=0; j<matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        if(top) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        if(bottom) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[matrix.length-1][i]=0;
            }
        }
        if(left) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
        if(right) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][matrix[0].length-1]=0;
            }
        }
    }
    public static void main(String[] args) {

    }
}
