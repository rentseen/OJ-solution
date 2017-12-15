import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> removeComments(String[] source) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<source.length;i++){
            sb.append(source[i]);
            sb.append('\n');
        }
        boolean flag = false;

        for(int i=0; i<sb.length(); i++){
            if(flag){
                if(i<sb.length()-1 && sb.charAt(i)=='*' && sb.charAt(i+1)=='/'){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    flag=false;
                }
                else
                    sb.deleteCharAt(i);
                i--;
            }
            else {
                if (i < sb.length() - 1 && sb.charAt(i) == '/' && sb.charAt(i + 1) == '*') {
                    flag = true;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    i--;
                } else if (i < sb.length() - 1 && sb.charAt(i) == '/' && sb.charAt(i + 1) == '/') {
                    while(sb.charAt(i)!='\n')
                        sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        StringBuilder s=new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='\n'){
                if(s.length()>0){
                    result.add(s.toString());
                    s = new StringBuilder();
                }
            }
            else
                s.append(sb.charAt(i));
        }

        return result;
    }
    public static void main(String[] args){
        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        removeComments(source);
    }
}
