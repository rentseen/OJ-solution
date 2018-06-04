public class Solution {
    public int generateCircle(int[][] result, int pos, int counter) {
        int len = result.length-2*pos;
        for(int i=0; i<len; i++) {
            result[pos][pos+i]=counter++;
        }
        for(int i=1; i<len; i++) {
            result[pos+i][result.length-pos-1]=counter++;
        }
        for(int i=1; i<len; i++) {
            result[result.length-pos-1][result.length-pos-1-i]=counter++;
        }
        for(int i=1; i<len-1; i++) {
            result[result.length-pos-1-i][pos]=counter++;
        }
        return counter;
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int counter = 1;
        for(int i=0; i<(n+1)/2; i++) {
            counter = generateCircle(result, i, counter);
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
