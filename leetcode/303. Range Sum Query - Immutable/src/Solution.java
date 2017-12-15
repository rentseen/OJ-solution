class NumArray {
    int[] nums;
    int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        int tmp=0;
        for(int i=0; i<nums.length; i++){
            tmp += nums[i];
            sums[i] = tmp;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j]-sums[i]+nums[i];
    }
}

public class Solution {

}
