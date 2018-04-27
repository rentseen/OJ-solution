import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, boolean[] flag) {
        if(list.size()==nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for(int x: list) {
                tmp.add(x);
            }
            result.add(tmp);
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!flag[i]) {
                flag[i]=true;
                list.add(nums[i]);
                dfs(result, nums, list, flag);
                flag[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(result, nums, list, flag);
        return result;
    }
}
