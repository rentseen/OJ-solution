import java.util.*;

/**
 * Created by rentseen on 17-4-20.
 */
public class Solution {
    public static boolean wordPattern(String pattern, String str) {
        Map<Character,String> kv= new HashMap<Character,String>();
        String[] strList=str.split(" ");
        List<String> content=Arrays.asList(strList);
        if(strList.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(kv.containsKey(pattern.charAt(i))){
                if(! (kv.get(pattern.charAt(i)).equals(content.get(i)))){
                    return false;
                }
            }
            else{
                if(kv.containsValue(content.get(i))){
                    return false;
                }
                else{
                    kv.put(pattern.charAt(i),content.get(i));
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String pattern="abba";
        String str="ha he he he";
        System.out.print(wordPattern(pattern,str));
    }
}
