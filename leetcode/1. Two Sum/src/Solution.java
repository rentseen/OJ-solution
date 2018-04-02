public class Solution {
    public void qSort(int[] nums, int[] pos, int l, int h) {
        if(l>=h)
            return;
        int low = l;
        int high = h;
        int k = nums[low];
        int kPos = pos[low];
        while(low<high){
            while(low<high && nums[high]>=k)
                high--;
            if(low<high) {
                nums[low]= nums[high];
                pos[low++] = pos[high];
            }
            while(low<high && nums[low]<k)
                low++;
            if(low<high) {
                nums[high] = nums[low];
                pos[high--] = pos[low];
            }
        }
        nums[low]=k;
        pos[low]=kPos;
        qSort(nums, pos, l, low-1);
        qSort(nums, pos, low+1, h);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] pos = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            pos[i]=i;
        qSort(nums, pos, 0, nums.length-1);
        int low = 0;
        int high = nums.length-1;
        while(low<high) {
            int sum = nums[low]+nums[high];
            if(sum>target)
                high--;
            else if(sum<target)
                low++;
            else {
                return new int[]{pos[low], pos[high]};
            }
        }
        return new int[]{};
    }
}
