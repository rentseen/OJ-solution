import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void dfs(boolean[] flag, List<List<Integer>> result, List<Integer> com, int n, int k, int depth) {
        if(depth==k) {
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<com.size(); i++) {
                tmp.add(com.get(i));
            }
            result.add(tmp);
            return;
        }
        if(com.size()>0 && depth+n-com.get(com.size()-1)<k)
            return;
        for(int i=com.size()==0?1:com.get(com.size()-1)+1; i<=n; i++) {
            if(!flag[i]) {
                flag[i]=true;
                com.add(i);
                dfs(flag, result, com, n, k, depth+1);
                com.remove(com.size()-1);
                flag[i]=false;
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[n+1];
        List<Integer> com = new ArrayList<>();
        dfs(flag, result, com, n, k, 0);
        return result;
    }
}
