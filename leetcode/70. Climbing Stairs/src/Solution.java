public class Solution {
    public int climbStairs(int n) {
        if(n<=1)
            return 1;
        int[] can = new int[n+1];
        can[0]=1;
        can[1]=1;
        for(int i=2; i<=n; i++) {
            can[i]=can[i-1]+can[i-2];
        }
        return can[n];
    }
    public static void main(String[] args) {

    }
}
