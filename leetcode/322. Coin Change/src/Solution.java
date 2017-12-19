public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount+1];
        for(int i=1; i<=amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                if(i-coins[j]>=0 && num[i-coins[j]]!=-1 && min>num[i-coins[j]]+1)
                    min = num[i-coins[j]] + 1;
            }
            if(min==Integer.MAX_VALUE)
                num[i]=-1;
            else
                num[i] = min;
        }
        return num[amount];
    }
}
