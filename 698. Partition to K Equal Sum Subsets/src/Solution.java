import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static boolean dfs(int cur, int target, int k, int[] nums, boolean[] vis){
        if(cur==target){
            if(k==1){
                return true;
            }
            cur = 0;
            k--;
        }
        for(int i=0; i<nums.length; i++){
            if(vis[i] || cur+nums[i]>target){
                continue;
            }
            vis[i] = true;
            if(dfs(cur+nums[i], target, k, nums, vis)){
                return true;
            }
            vis[i] = false;
        }
        return false;
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length<k){
            return false;
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
        }
        if(sum%k!=0 || max>sum/k){
            return false;
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length/2;i++){
            int tmp = nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=tmp;
        }

        boolean []vis = new boolean[nums.length];
        return dfs(0,sum/k, k, nums, vis);

    }
    public static void main(String[] args){
        int []nums = {4,5,3,2,5,5,5,1,5,5,5,5,3,5,5,2};
        int k = 13;
        System.out.println(canPartitionKSubsets(nums, k));
    }
}
