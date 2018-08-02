import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int get(int num, int n, List<Integer> result) {
        if(n<0) {
            result.add(num);
            return num;
        }
        num = get(num, n-1, result);
        num = num ^ (1<<n);
        return get(num, n-1, result);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        get(0, n-1, result);
        return result;
    }
}
