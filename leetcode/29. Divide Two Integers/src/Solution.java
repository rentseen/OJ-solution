public class Solution {
    public static int cal(long dividend, long divisor) {
        if(dividend<divisor)
            return 0;
        if(dividend==divisor)
            return 1;
        int result=0;
        int count=1;
        long cum=divisor;
        while(true) {
            if(cum+cum<dividend) {
                count=count+count;
                cum=cum+cum;
            }
            else if(cum+cum==dividend) {
                count=count+count;
                result += count;
                break;
            }
            else {
                result += count;
                dividend-=cum;
                if(dividend<divisor)
                    break;
                cum=divisor;
                count=1;
            }
        }
        return result;
    }
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==1)
            return Integer.MIN_VALUE;
        if(dividend==Integer.MAX_VALUE && (divisor==1 || divisor==-1))
            return divisor*dividend;
        if(dividend==Integer.MIN_VALUE && divisor==Integer.MIN_VALUE)
            return 1;
        if(divisor==Integer.MIN_VALUE)
            return 0;
        if(dividend==0)
            return 0;
        int sign1 = dividend>0?1:-1;
        int sign2 = divisor>0?1:-1;
        if(dividend==Integer.MIN_VALUE) {
            if(Math.abs(dividend+Math.abs(divisor))>Math.abs(divisor))
                return sign1*sign2*(1+cal(Math.abs(dividend+Math.abs(divisor)), Math.abs(divisor)));
            else
                return sign1*sign2*1;
        }
        int result = cal(Math.abs(dividend), Math.abs(divisor));
        return result*sign1*sign2;
    }
    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
    }
}
