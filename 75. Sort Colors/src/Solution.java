public class Solution {
    public static void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void sortColors(int[] nums) {
        int low=0;
        int index=0;
        int high=nums.length-1;
        while(index<=high){
            if(nums[index]==0)
                swap(low++, index++, nums);
            else if(nums[index]==1)
                index++;
            else
                swap(high--, index, nums);
        }
    }
    public static void main(String[] args){
        int[] nums = {1, 0};
        sortColors(nums);
    }
}
