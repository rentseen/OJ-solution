public class Solution {
    public static void qSort(int[] nums, int low, int high){
        if(low>=high)
            return;
        int k = nums[low];
        int l = low;
        int h = high;
        while(l<h){
            while(l<h && nums[h]>=k)
                h--;
            if(l<h)
                nums[l++] = nums[h];
            while(l<h && nums[l]<=k)
                l++;
            if(l<h)
                nums[h--] = nums[l];
        }
        nums[l]=k;
        qSort(nums, low, l-1);
        qSort(nums, l+1, high);
    }
    public static int findLHS(int[] nums) {
        qSort(nums, 0, nums.length-1);
        int max = 0;
        int back = 0;
        int mid = back;
        for(int i=1; i<nums.length; i++){
            int step = nums[i]-nums[back];
            if(step==1){
                if(mid==back)
                    mid=i;
            }
            else if(step>1){
                if(mid!=back){
                    int diff = i-back;
                    if(diff>max)
                        max = diff;
                    back=mid;
                    i--;
                }
                else{
                    back=i;
                    mid=i;
                }
            }
        }
        if(mid!=back && max<nums.length-back)
            max=nums.length-back;
        return max;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,1};
        System.out.println(findLHS(nums));
    }
}
