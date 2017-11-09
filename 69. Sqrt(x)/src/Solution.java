public class Solution {
    public static int mySqrt(int x) {
        int result=0;
        while(result*result<=x && result*result>=0)
            result++;
        return result-1;
    }
    public static void main(String[] args){
        System.out.println(mySqrt(2147395600));
    }
}
