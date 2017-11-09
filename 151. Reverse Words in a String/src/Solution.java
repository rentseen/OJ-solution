public class Solution {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int base = s.length()-1;
        while(base>=0 && s.charAt(base)==' ')
            base--;
        for(int i=base; i>=0; i--){
            if(s.charAt(i)==' '){
                sb.append(s.substring(i+1, base+1));
                sb.append(' ');
                while(i>=0 && s.charAt(i)==' '){
                    i--;
                }
                base = i;
                i++;
            }
        }
        if(base>=0)
            sb.append(s.substring(0, base+1));
        else if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(reverseWords(" a  b "));
    }
}
