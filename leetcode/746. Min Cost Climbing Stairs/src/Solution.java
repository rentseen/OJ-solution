public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=2)
            return 0;
        int[] C = new int[cost.length+1];
        for(int i=2; i<C.length; i++){
            C[i]=Math.min(C[i-2]+cost[i-2], C[i-1]+cost[i-1]);
        }
        return C[C.length-1];
    }
}
