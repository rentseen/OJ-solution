import java.util.ArrayList;
        import java.util.List;

public class Solution {
    public void dfs(String digits, StringBuilder sb, String[] nums, List<String> result, int pos) {
        if(pos==digits.length()) {
            result.add(sb.toString());
            return;
        }
        int x = digits.charAt(pos)-'0';
        for(int i=0; i<nums[x].length(); i++) {
            sb.append(nums[x].charAt(i));
            dfs(digits, sb, nums, result, pos+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        dfs(digits, new StringBuilder(), nums, result, 0);
        return result;
    }
}
