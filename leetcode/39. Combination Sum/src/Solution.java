import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(int[] candidates, int target, int pos, List<Integer> nums, List<List<Integer>> result, int sum) {
        if(sum==target) {
            //todo
            List<Integer> tmp = new ArrayList<>();
            for(int x: nums) {
                tmp.add(x);
            }
            result.add(tmp);
            return;
        }
        else if(sum>target) {
            return;
        }
        else if(pos==candidates.length) {
            return;
        }
        else {
            nums.add(candidates[pos]);
            dfs(candidates, target, pos, nums, result, sum+candidates[pos]);
            nums.remove(nums.size()-1);
            dfs(candidates, target, pos+1, nums, result, sum);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, nums, result, 0);
        return result;
    }
}
