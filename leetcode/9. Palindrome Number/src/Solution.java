public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int[] nums = new int[12];
        int len = 0;
        while(x!=0) {
            nums[len++] = x%10;
            x=x/10;
        }
        for(int i=0; i<len/2; i++) {
            if(nums[i]!=nums[len-i-1])
                return false;
        }
        return true;
    }
}
