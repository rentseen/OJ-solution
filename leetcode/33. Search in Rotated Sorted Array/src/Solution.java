public class Solution {
    public int search(int[] nums, int low, int high, int target) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]>target) {
                high = mid - 1;
            }
            else if(nums[mid]<target) {
                low = mid + 1;
            }
            else
                return mid;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(high>=low) {
            int mid = low+(high-low)/2;
            if(nums[mid]>=nums[low]) {
                if(target>=nums[low] && target<=nums[mid]) {
                    return search(nums, low, mid, target);
                }
                else {
                    //in right
                    low = mid + 1;
                }
            }
            else {
                if(target>=nums[mid] && target<=nums[high]) {
                    //in here
                    return search(nums, mid, high, target);
                }
                else {
                    //in left
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
