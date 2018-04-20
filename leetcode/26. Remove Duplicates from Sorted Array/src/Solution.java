public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int len = 0;
        int back=0;
        int front=0;
        for(;front<nums.length-1; front++) {
            if(nums[front]!=nums[front+1]) {
                nums[back++]=nums[front];
                len++;
            }
        }
        nums[back]=nums[front];
        len++;
        return len;
    }
}
