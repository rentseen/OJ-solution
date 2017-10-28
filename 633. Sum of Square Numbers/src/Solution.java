import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean judgeSquareSum(int c) {
        int a=(int)Math.sqrt(c/2);
        int mulA=a*a;
        while(mulA <= c && mulA>=0){
            int b = (int) Math.sqrt(c-mulA);
            if(mulA+b*b==c)
                return true;
            a++;
            mulA = a*a;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(judgeSquareSum(2147483643));
    }
}
