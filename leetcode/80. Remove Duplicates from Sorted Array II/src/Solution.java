public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int prev = -1;
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=prev) {
                prev=nums[i];
                count=1;
                nums[index++]=prev;
            }
            else {
                count++;
                if(count<=2) {
                    nums[index++]=prev;
                }
            }
        }
        return index;
    }
}
