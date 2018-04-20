public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        int ih=0;
        int in=0;
        while(ih<haystack.length()&&in<needle.length()) {
            if(haystack.charAt(ih)==needle.charAt(in)) {
                ih++;
                in++;
                if(in==needle.length()) {
                    return ih-in;
                }
            }
            else {
                ih=ih-in+1;
                in=0;
            }
        }
        return -1;
    }
}
