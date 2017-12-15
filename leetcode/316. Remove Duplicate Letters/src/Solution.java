import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        int []count = new int[26];
        boolean [] flag = new boolean[s.length()];
        for(int i=0; i<sb.length(); i++){
            count[sb.charAt(i)-'a']++;
        }
        int base = 0;
        int min = 0;
        for(int i=0; i<sb.length(); i++){
            if(!flag[i]){
                count[sb.charAt(i)-'a']--;
                if(sb.charAt(i)<sb.charAt(min)){
                    min = i;
                }
                if((count[sb.charAt(i)-'a']==0) || (i==sb.length()-1 && min<sb.length())){

                    for(int j=min+1; j<=i; j++){
                        count[sb.charAt(j)-'a']++;
                    }
                    for(int j=base; j<min; j++){
                        flag[j] = true;
                    }
                    for(int j=min+1; j<sb.length(); j++){
                        if(sb.charAt(j)==sb.charAt(min)){
                            flag[j]=true;
                        }
                    }
                    result.append(sb.charAt(min));
                    base = min + 1;
                    while(base<sb.length() && flag[base]){
                        base++;
                    }
                    min = base;
                    i=base-1;
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(removeDuplicateLetters("bbbacacca"));
    }
}
