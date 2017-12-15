import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) nums[(nums[i]>=0?nums[i]:-nums[i])-1] = nums[(nums[i]>=0?nums[i]:-nums[i])-1]>0?-nums[(nums[i]>=0?nums[i]:-nums[i])-1]:nums[(nums[i]>=0?nums[i]:-nums[i])-1];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length;i++) if(nums[i]>=0) result.add(i+1);
        return result;
    }
    public static void main(String[] args){

    }
}
