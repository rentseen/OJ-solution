public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if(nums[low]==target)
            return low;
        low = Math.max(low, high);
        return nums[low]>target ? low : low + 1;
    }
    public static void main(String[] args){
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }
}
