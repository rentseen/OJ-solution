/**
 * Created by Yelinsheng on 17-3-23.
 */
public class GuessGame {
    private static int num=1702766719;
    protected static int guess(int n){
        if(n<num){
            return 1;
        }
        else if(n==num){
            return 0;
        }
        else{
            return -1;
        }
    }
}
