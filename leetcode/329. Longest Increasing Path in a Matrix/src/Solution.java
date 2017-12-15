import java.util.Arrays;

/**
 * Created by rentseen on 17-3-29.
 */
public class Solution {
    public static boolean ifBound(int i,int j,int x,int y){
        if(i<0 || i>=x){
            return false;
        }
        if(j<0 || j>=y){
            return false;
        }
        return true;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] length=new int[matrix.length][matrix[0].length];
        boolean flag=true;
        while(flag){

            flag=false;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){

                    if(ifBound(i-1,j,matrix.length,matrix[0].length) && matrix[i-1][j]<matrix[i][j] &&length[i-1][j]+1>length[i][j]){
                        length[i][j]=length[i-1][j]+1;
                        flag=true;
                    }
                    if(ifBound(i+1,j,matrix.length,matrix[0].length) && matrix[i+1][j]<matrix[i][j] &&length[i+1][j]+1>length[i][j]){
                        length[i][j]=length[i+1][j]+1;
                        flag=true;
                    }
                    if(ifBound(i,j-1,matrix.length,matrix[0].length) && matrix[i][j-1]<matrix[i][j] &&length[i][j-1]+1>length[i][j]){
                        length[i][j]=length[i][j-1]+1;
                        flag=true;
                    }
                    if(ifBound(i,j+1,matrix.length,matrix[0].length) && matrix[i][j+1]<matrix[i][j] &&length[i][j+1]+1>length[i][j]){
                        length[i][j]=length[i][j+1]+1;
                        flag=true;
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if(length[i][j]>max){
                    max=length[i][j];
                }
            }
        }
        return max+1;
    }
    public static void main(String[] args){
        int[][] nums = {{9},{4}};
        System.out.println(longestIncreasingPath(nums));
    }
}
