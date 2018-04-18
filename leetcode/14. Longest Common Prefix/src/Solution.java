public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        out:
        while(true) {
            if(index>=strs[0].length())
                break;
            char c = strs[0].charAt(index);
            for(int i=0; i<strs.length; i++) {
                if(index>=strs[i].length() || c!=strs[i].charAt(index))
                    break out;
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
