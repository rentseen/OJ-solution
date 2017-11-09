public class Solution {
    public static int arrangeCoins(int n) {
        int sum=0;
        int i=0;
        while(sum<=n && sum>=0)
            sum += i++;
        return i-2;
    }
    public static void main(String[] args){
        System.out.println(arrangeCoins(2147483647));
    }
}
