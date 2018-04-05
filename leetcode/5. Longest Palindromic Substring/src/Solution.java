public class Solution {
    public static String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        int max = 1;
        int base = 0;
        for(int i=0; i<s.length();i++) {
            int tmp = 1;
            int j=1;
            for(; i+j<s.length() && i-j>=0; j++) {
                if(s.charAt(i+j)==s.charAt(i-j)) {
                    tmp += 2;
                }
                else {
                    break;
                }
            }
            if(tmp>max) {
                max = tmp;
                base = i-j+1;
            }

            tmp = 0;
            j=1;
            for(; i+j<s.length() && i-j+1>=0; j++) {
                if(s.charAt(i+j)==s.charAt(i-j+1)) {
                    tmp += 2;
                }
                else {
                    break;
                }
            }
            if(tmp>max) {
                max = tmp;
                base = i-j+2;
            }
        }
        return s.substring(base, base+max);
    }
    public static void main(String[] args) {
        String s = "bb";
        longestPalindrome(s);
    }
}
