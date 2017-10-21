public class Solution {
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dis[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    dis[i][j]=0;
                }
                else{
                    dis[i][j]=Integer.MAX_VALUE-1;
                }
            }
        }
        while(true){
            boolean flag = false;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    //left
                    if(i-1>=0 && dis[i-1][j]+1<dis[i][j]){
                        dis[i][j] = dis[i-1][j]+1;
                        flag = true;
                    }
                    //right
                    if(i+1<m && dis[i+1][j]+1<dis[i][j]){
                        dis[i][j] = dis[i+1][j]+1;
                        flag = true;
                    }
                    //top
                    if(j+1<n && dis[i][j+1]+1<dis[i][j]){
                        dis[i][j] = dis[i][j+1]+1;
                        flag = true;
                    }
                    //bottom
                    if(j-1>=0 && dis[i][j-1]+1<dis[i][j]){
                        dis[i][j] = dis[i][j-1]+1;
                        flag = true;
                    }
                }
            }
            if(!flag){
                break;
            }
        }
        return dis;
    }
    public static void main(String[] args){
        int matrix[][] = {{0,0,0},{0,1,0},{0,0,0}};
        updateMatrix(matrix);
    }
}