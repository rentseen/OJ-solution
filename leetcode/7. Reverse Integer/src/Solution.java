public class Solution {
    public static int reverse(int x) {
        if(x==0)
            return 0;
        int sign = x>0? 1:-1;
        x=Math.abs(x);
        while(x%10==0)
            x=x/10;
        int result = 0;
        while(x!=0) {
            int tmp = result;
            for(int i=0; i<9; i++) {
                result += tmp;
                if(result<0)
                    return 0;
            }
            result = result + x%10;
            x = x/10;
        }
        return sign*result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
