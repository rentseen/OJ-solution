public class Solution {
    public int missingNumber(int[] nums) {
        boolean ifN = false;
        for(int i=0; i<nums.length; i++){
            int v = Math.abs(nums[i]);
            if(v<nums.length){
                nums[v] = -nums[v];
            }
            else{
                ifN = true;
            }
        }
        if(!ifN)
            return nums.length;
        int zero=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                return i;
            if(nums[i]==0)
                zero = i;
        }
        return zero;
    }
}
