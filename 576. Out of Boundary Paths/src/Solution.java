public class Solution {
    public static int findPaths(int[][][] record, int m, int n, int path, int N, int i, int j){
        if(path>N)
            return 0;
        if(i==-1 || i==m || j==-1 ||j==n)
            return 1;
        if(record[i][j][path]!=-1)
            return record[i][j][path];
        int result = 0;
        result = (result + findPaths(record, m, n, path+1, N, i-1, j))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i+1, j))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i, j-1))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i, j+1))%1000000007;
        record[i][j][path] = result;
        return result;
    }
    public static int findPaths(int m, int n, int N, int i, int j) {
        int path = 0;
        int[][][] record = new int[m][n][N+1];
        for(int a=0; a<m; a++)
            for(int b=0; b<n; b++)
                for(int c=0; c<=N; c++)
                    record[a][b][c]=-1;

        int result = 0;
        result = (result + findPaths(record, m, n, path+1, N, i-1, j))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i+1, j))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i, j-1))%1000000007;
        result = (result + findPaths(record, m, n, path+1, N, i, j+1))%1000000007;
        return result;
    }
    public static void main(String[] args){
        int m = 36, n = 5, N = 50, i = 15, j = 3;
        System.out.println(findPaths(m, n, N, i, j));
    }
}
