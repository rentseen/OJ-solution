import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void twoSum(int[] nums, int target, int p1, int p2, List<List<Integer>> result){
        int left=p2+1;
        int right=nums.length-1;
        while(right>left){
            if(left==p1 || left==p2){
                left++;
                continue;
            }
            if(right==p1 || right==p2){
                right--;
                continue;
            }
            if(nums[left]+nums[right]<target)
                left++;
            else if(nums[left]+nums[right]==target){
                ArrayList<Integer> al = new ArrayList<>();
                al.add(nums[p1]);
                al.add(nums[p2]);
                al.add(nums[left]);
                al.add(nums[right]);
                Collections.sort(al);
                result.add(al);
                while(left <right && nums[left]==nums[left+1])
                    left++;
                while(left<right && nums[right]==nums[right-1])
                    right--;
                left++;
            }
            else
                right--;
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                twoSum(nums, target-nums[i]-nums[j], i, j, result);
                while(j+1<nums.length && nums[j]==nums[j+1])
                    j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1])
                i++;
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        fourSum(nums, target);
    }
}
