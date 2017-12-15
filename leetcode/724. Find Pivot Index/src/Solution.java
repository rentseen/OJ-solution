public class Solution {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        int tmp=0;
        for(int i=0; i<nums.length; i++){
            if(tmp==sum-tmp-nums[i])
                return i;
            tmp += nums[i];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 1};
        System.out.println(pivotIndex(nums));
    }
}
