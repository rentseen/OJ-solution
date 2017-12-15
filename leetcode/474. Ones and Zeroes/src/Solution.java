import java.util.Arrays;

/**
 * Created by rentseen on 17-3-20.
 */
public class Solution {
    public static int countZeros(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                sum++;
            }
        }
        return sum;
    }
    public static int countOnes(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                sum++;
            }
        }
        return sum;
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[] numOfOnes=new int[strs.length];
        int[] numOfZeros=new int[strs.length];
        int sumOfOnes=0;
        int sumOfZeros=0;
        for(int i=0;i<strs.length;i++){
            numOfOnes[i]=countOnes(strs[i]);
            sumOfOnes+=numOfOnes[i];
            numOfZeros[i]=countZeros(strs[i]);
            sumOfZeros+=numOfZeros[i];
        }
        if(sumOfZeros<=m && sumOfOnes<=n){
            return strs.length;
        }
        int [][][]M=new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int numOfOne=numOfOnes[i-1];
                    int numOfZero=numOfZeros[i-1];
                    int max=0;
                    if(j-numOfZero>=0 && k-numOfOne>=0){
                        max=M[i-1][j-numOfZero][k-numOfOne]+1;
                    }
                    if(i-1>=0){
                        max=max>M[i-1][j][k]?max:M[i-1][j][k];
                    }
                    if(j-1>=0){
                        max=max>M[i][j-1][k]?max:M[i][j-1][k];
                    }
                    if(k-1>=0){
                        max=max>M[i][j][k-1]?max:M[i][j][k-1];
                    }
                    M[i][j][k]=max;
                    if(max>=strs.length){
                        return max;
                    }
                }
            }
        }
        return M[strs.length][m][n];
    }
    public static void main(String[] args){
        String[] strs={"0","0","0","0","1","0","1","1","1","1","1","1","0","0","1","1","1","1","1","1","1","1","0","0","1","0","1","0"};
        System.out.println(findMaxForm(strs,1,79));
    }
}
