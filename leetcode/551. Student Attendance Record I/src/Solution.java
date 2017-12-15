/**
 * Created by rentseen on 17-5-3.
 */
public class Solution {
    public static boolean checkA(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkL(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                if(count>1){
                    return false;
                }
                else{
                    count++;
                }
            }
            else{
                count=0;
            }
        }
        return true;
    }
    public static boolean checkRecord(String s) {
        if(checkA(s)&&checkL(s)){
            return true;
        }
        else return false;
    }
    public static void main(String[] args){
        System.out.println(checkRecord("PPALLL"));
    }
}
