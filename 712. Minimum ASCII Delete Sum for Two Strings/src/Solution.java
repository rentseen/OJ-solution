public class Solution {
    public static int minimumDeleteSum(String s1, String s2) {
        int result[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            result[i][0] = result[i-1][0] + s1.charAt(i-1);
        }
        for(int i=1; i<=s2.length(); i++){
            result[0][i] = result[0][i-1] + s2.charAt(i-1);
        }
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    result[i][j]=result[i-1][j-1];
                }
                else{
                    result[i][j] = Math.min(result[i-1][j]+s1.charAt(i-1), result[i][j-1]+s2.charAt(j-1));
                }

            }
        }
        return result[s1.length()][s2.length()];
    }
    public static void main(String[] args){
        String s1 = "delete", s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }
}
