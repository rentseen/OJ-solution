public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<=high) {
            mid = low + (high-low)/2;
            if(nums[mid]==target) {
                int l=mid;
                int h=mid;
                for(;l>=low;l--) {
                    if(l==0)
                        break;
                    if(nums[l-1]!=target)
                        break;
                }
                for(;h<=high;h++) {
                    if(h==nums.length-1)
                        break;
                    if(nums[h+1]!=target)
                        break;
                }
                return new int[] {l,h};
            }
            else if(nums[mid]>target) {
                high = mid-1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
        }
        return new int[] {-1,-1};
    }
}
