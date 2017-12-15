public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int base = 0;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(base)==t.charAt(i))
                base++;
            if(base==s.length())
                return true;
        }
        return false;
    }
}
