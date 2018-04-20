public class Solution {
    public int removeElement(int[] nums, int val) {
        int back=0;
        int front=0;
        for(; front<nums.length; front++) {
            if(nums[front]!=val) {
                nums[back++]=nums[front];
            }
        }
        return back;
    }
}
