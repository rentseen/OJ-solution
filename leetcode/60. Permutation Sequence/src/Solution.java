import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String getPermutation(int n, int k) {
        k--;
        int[] fac = new int[n+1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i-1]*i;
        }
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            number.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >=0 ; i--) {
            int index = k/fac[i];
            sb.append(number.get(index));
            number.remove(index);
            k = k - k/fac[i]*fac[i];
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}
