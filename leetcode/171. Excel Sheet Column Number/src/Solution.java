/**
 * Created by Yelinsheng on 2017/3/28.
 */
public class Solution {
    public static int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sum=26*sum+(c-'A'+1);
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.print(titleToNumber("AA"));
    }
}
