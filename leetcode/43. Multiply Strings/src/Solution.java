import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String multiply(String num, char c, int count) {
        int digit = c - '0';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(0);
        }
        int advance = 0;
        for(int i=num.length()-1; i>=0; i--) {
            int tmp = (num.charAt(i)-'0')*digit+advance;
            sb.append(tmp%10);
            advance=tmp/10;
        }
        if(advance!=0) {
            sb.append(advance);
        }
        return sb.toString();
    }
    public static String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int advance = 0;
        int i;
        for(i=0; i<num1.length() && i<num2.length(); i++) {
            int tmp=advance + (num1.charAt(i)-'0') + (num2.charAt(i)-'0');
            sb.append(tmp%10);
            advance = tmp/10;
        }
        while(i<num1.length()) {
            int tmp=advance + (num1.charAt(i++)-'0');
            sb.append(tmp%10);
            advance = tmp/10;
        }
        while(i<num2.length()) {
            int tmp=advance + (num2.charAt(i++)-'0');
            sb.append(tmp%10);
            advance = tmp/10;
        }
        if(advance!=0){
            sb.append(advance);
        }
        return sb.toString();
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> list = new ArrayList<>();
        for(int i=num2.length()-1; i>=0; i--) {
            char c = num2.charAt(i);
            if(c!='0') {
                list.add(multiply(num1, c, num2.length()-1-i));
            }
        }
        int count = list.size()-1;
        for(int i=0; i<count; i++) {
            String s = add(list.get(0), list.get(1));
            list.remove(0);
            list.remove(0);
            list.add(0, s);
        }
        StringBuilder sb = new StringBuilder();
        String s = list.get(0);
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        multiply("123", "456");
    }
}
