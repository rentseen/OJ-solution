public class Solution {
    //dp
    /*public static int maxProfit(int[] prices, int fee) {
        int profit[] = new int[prices.length];
        for(int i=1; i<profit.length; i++){
            for(int j=0; j<i; j++){
                int tmp = prices[i]-prices[j]-fee>0?prices[i]-prices[j]-fee:0;
                if(profit[j]+tmp>profit[i]){
                    profit[i]=profit[j]+tmp;
                }
            }
        }

        return profit[profit.length-1];
    }*/
    public static int maxProfit(int[] prices, int fee) {
        int s0[] = new int[prices.length];
        int s1[] = new int[prices.length];
        int s2[] = new int[prices.length];

        s0[0] = -prices[0];
        s1[0] = -fee;
        s2[0] = 0;
        for(int i=1; i<prices.length; i++){
            s0[i] = Math.max(s0[i-1], s2[i-1]-prices[i]);
            s0[i] = Math.max(s0[i], s1[i-1]-prices[i]);
            s1[i] = s0[i-1] + prices[i] - fee;
            s2[i] = Math.max(s1[i-1], s2[i-1]);
        }
        return Math.max(s2[prices.length-1],s1[prices.length-1]);
    }
    public static void main(String[] args){
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}