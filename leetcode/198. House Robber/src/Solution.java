public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            int s1 = nums[i];
            if(i-2>=0) {
                s1 += max[i-2];
            }
            max[i] = Math.max(max[i-1], s1);
        }
        return max[nums.length-1];
    }
}