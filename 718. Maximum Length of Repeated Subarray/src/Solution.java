public class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] l = new int[A.length+1][B.length+1];
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1]!=B[j-1])
                    l[i][j]=0;
                else
                    l[i][j]=l[i-1][j-1]+1;
            }
        }
        int max = 0;
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(l[i][j]>max)
                    max = l[i][j];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
    }
}
