public class Solution {
    public int maxSubArray(int[] nums) {
        int prev = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            prev = prev>0?prev+nums[i]:nums[i];
            max = Math.max(max, prev);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
