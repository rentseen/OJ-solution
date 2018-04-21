import java.util.Arrays;

public class Solution {
    public void sort(int[] nums, int low, int high) {
        if(low>=high)
            return;
        int k=nums[low];
        int l=low;
        int h=high;
        while(h>l) {
            while(h>l&&nums[h]>=k) {
                h--;
            }
            if(h>l) {
                nums[l++]=nums[h];
            }
            while (h>l && nums[l]<k) {
                l++;
            }
            if (h>l) {
                nums[h--]=nums[l];
            }
        }
        nums[l]=k;
        sort(nums, low, l-1);
        sort(nums, l+1, high);
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return;
        for(int i=nums.length-2; i>=0; i--) {
            int index=i;
            int min=Integer.MAX_VALUE;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]>nums[i] && nums[j]<min) {
                    min=nums[j];
                    index=j;
                }
            }
            if(index!=i) {
                int tmp=nums[index];
                nums[index]=nums[i];
                nums[i]=tmp;
                sort(nums, i+1, nums.length-1);
                return;
            }
        }
        sort(nums, 0, nums.length-1);
    }
}