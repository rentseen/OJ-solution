public class Solution {
    public static boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        int low = 1;
        int high = 50000;
        int mid;
        int time;
        while(low<high){
            mid = low+(high-low)/2;
            time = mid*mid;
            if(time<0){
                high=mid-1;
            }
            else{
                if(time>num)
                    high=mid-1;
                else if(time<num)
                    low=mid+1;
                else
                    return true;
            }
        }
        if(high*high==num)
            return true;
        return false;
    }
    public static void main(String[] args){
        System.out.println(isPerfectSquare(2147395600));
    }
}
