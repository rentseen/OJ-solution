public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, i+nums[i]);
            if(max>=nums.length)
                return true;
            if(max==i)
                return false;
        }
        return true;
    }
}
