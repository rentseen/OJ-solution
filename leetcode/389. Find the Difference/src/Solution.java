import java.util.Arrays;

/**
 * Created by Yelinsheng on 17-3-22.
 */
public class Solution {
    public static char findTheDifference(String s, String t) {
        char[] sc=s.toCharArray();
        Arrays.sort(sc);
        s=new String(sc);
        char[] tc=t.toCharArray();
        Arrays.sort(tc);
        t=new String(tc);
        int is=0,it=0;
        char result=0;
        while(is<s.length() && it<t.length()){
            if(s.charAt(is)==t.charAt(it)){
                is++;
                it++;
                continue;
            }
            else{
                result=t.charAt(it);
                break;
            }
        }
        if(it==t.length()-1){
            result=t.charAt(it);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.print(findTheDifference("cdab","abcde"));
    }
}
