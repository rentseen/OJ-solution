/**
 * Created by rentseen on 17-4-19.
 */
public class Solution {
    public static String getSay(String count){
        String say="";
        int base=0;
        int len=0;
        for(int i=0;i<count.length();i++){
            if(count.charAt(i)==count.charAt(base)){
                len++;
            }
            else{
                say=say+len;
                say=say+count.charAt(base);
                base=i;
                len=1;
            }
        }
        say=say+len;
        say=say+count.charAt(base);
        return say;
    }
    public static String countAndSay(int n) {
        String count="1";
        String say="";
        for(int i=1;i<n;i++){
            say=getSay(count);
            count=say;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }
}
