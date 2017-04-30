import java.util.ArrayList;
import java.util.List;

/**
 * Created by rentseen on 17-4-30.
 */
public class Solution {
    public static int find(List<Character> ch, char x){
        for(int i=0;i<ch.size();i++){
            if(ch.get(i)==x){
                return i;
            }
        }
        return -1;
    }
    public static int firstUniqChar(String s) {
        List<Character> ch=new ArrayList<>();
        List<Boolean> flag=new ArrayList<>();
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int pos=find(ch,s.charAt(i));
            if(pos==-1){
                ch.add(s.charAt(i));
                flag.add(false);
                index.add(i);
            }
            else{
                flag.set(pos,true);
            }
        }
        for(int i=0;i<flag.size();i++){
            if(flag.get(i)==false){
                return index.get(i);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
