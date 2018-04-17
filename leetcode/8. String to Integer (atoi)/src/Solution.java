public class Solution {
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        int index = 0;
        while(index<str.length() && str.charAt(index)==' ')
            index++;
        if(index==str.length())
            return 0;
        char c = str.charAt(index);
        int sign = 1;
        if(c=='-') {
            sign = -1;
            index++;
        }
        else if(c=='+'){
            sign = 1;
            index++;
        }
        else if(!(c>='0' && c<='9')) {
            return 0;
        }
        long result = 0;
        for(;index<str.length(); index++) {
            c = str.charAt(index);
            if(!(c>='0' && c<='9')) {
                return (int)(sign*result);
            }
            result = result*10+(c-'0');
            if(sign==1 && result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign==-1 && sign*result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)(sign*result);
    }
}
