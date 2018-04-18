public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] R = new boolean[s.length()+1][p.length()+1];
        R[0][0]=true;
        for(int i=1; i<p.length(); i=i+2) {
            if(p.charAt(i)=='*') {
                R[0][i+1] = true;
            }
            else {
                break;
            }
        }
        if(p.length()>=2 && p.charAt(1)=='*') {
            R[0][2] = true;
        }

        for(int i=1; i<=s.length(); i++) {
            for(int j=1; j<=p.length(); j++) {
                char sc = s.charAt(i-1);
                char sp = p.charAt(j-1);
                if(sc==sp || sp=='.') {
                    R[i][j] = R[i-1][j-1];
                }
                else if(sp=='*') {
                    if(p.charAt(j-2)==sc || p.charAt(j-2)=='.') {
                        R[i][j] = R[i-1][j] || R[i][j-1] || R[i][j-2];
                    }
                    else {
                        R[i][j] = R[i][j-2];
                    }

                }
            }
        }
        return R[s.length()][p.length()];
    }
}
