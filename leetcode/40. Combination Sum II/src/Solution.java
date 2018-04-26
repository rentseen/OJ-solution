import java.util.*;

public class Solution {
    public static void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> nums, int pos, int sum) {
        if(sum==target) {
            List<Integer> tmp = new ArrayList<>();
            for(int x: nums) {
                tmp.add(x);
            }
            if(result.add(tmp));
            return;
        }
        else if(sum>target || pos==candidates.length) {
            return;
        }
        else {
            int tail=pos+1;
            for(; tail<candidates.length; tail++) {
                if(candidates[pos]!=candidates[tail])
                    break;
            }
            int len=tail-pos;
            for(int i=0; i<=len; i++) {
                dfs(candidates, target, result, nums, tail, sum);
                sum=sum+candidates[pos];
                nums.add(candidates[pos]);
            }
            for(int i=0; i<=len; i++) {
                nums.remove(nums.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        dfs(candidates, target, result, nums, 0, 0);
        return result;
    }
    public static void main(String[] args) {
        int[] candidates = {5,3,2,4,2,5,2,4,3};
        int target = 8;
        combinationSum2(candidates, target);
    }
}
