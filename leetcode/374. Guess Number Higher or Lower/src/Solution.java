/**
 * Created by Yelinsheng on 17-3-23.
 */
public class Solution extends GuessGame{
    public static int guessNumber(int n) {
        int low=1;
        int high=n;
        while(low<high){
            int mid=(high/2+low/2);
            int flag=guess(mid);
            if(flag==-1){
                high=mid-1;
            }
            else if(flag==0){
                return mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        System.out.print(guessNumber(2126753390));
    }
}
