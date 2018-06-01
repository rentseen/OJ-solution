public class Solution {
    public static double myPow(double x, int n) {
        if(Double.isInfinite(x))
            return 0;
        double result = 1;
        if(n==0) {
            return 1;
        }
        if(n<0) {
            n=-n;
            x=1/x;
        }

        if(n%2==0)
            return myPow(x*x, n/2);
        else
            return x*myPow(x*x, n/2);
    }
    public static void main(String[] args) {
        System.out.println(myPow(2.00000 , -2147483648));
    }
}
