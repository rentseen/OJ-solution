import java.util.Arrays;

/**
 * Created by rentseen on 17-3-30.
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultDiff=Math.abs(nums[0]+nums[1]+nums[2]-target);
        int resultSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(right>left){
                int sum=nums[i]+nums[left]+nums[right];
                int diff=Math.abs(sum-target);
                if(diff<resultDiff){
                    resultDiff=diff;
                    resultSum=sum;
                }
                if(sum<target){
                    left++;
                }
                else if(sum==target){
                    return target;
                }
                else{
                    right--;
                }
            }
        }
        return resultSum;
    }
    public static void main(String[] args){
        int[] nums={0, 1, 2};
        System.out.println(threeSumClosest(nums,3));
    }
}
