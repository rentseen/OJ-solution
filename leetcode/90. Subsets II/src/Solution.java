import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void dfs(int[] nums, List<List<Integer>> result, int index, List<Integer> list) {
        if(index==nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for(int x: list) {
                tmp.add(x);
            }
            result.add(tmp);
            return;
        }
        int start = index;
        int end = start;
        for(int i=index; i<nums.length; i++) {
            if(nums[i]!=nums[start]) {
                end = i;
                break;
            }
            else if(i==nums.length-1) {
                end = nums.length;
            }
        }
        dfs(nums, result, end, list);
        for(int i=start; i<end; i++) {
            list.add(nums[start]);
            dfs(nums, result, end, list);
        }
        for(int i=start; i<end; i++) {
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0, new ArrayList<>());
        return result;
    }
}