public class Solution {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder sb = new StringBuilder(licensePlate.toLowerCase());
        for(int i=sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(c<'a' || c>'z'){
                sb.deleteCharAt(i);
            }
        }
        int[] aux = new int[26];
        for(int i=0; i<sb.length(); i++){
            aux[sb.charAt(i)-'a']++;
        }
        int[] count = new int[26];
        int min = Integer.MAX_VALUE;
        int index = -1;
        out:
        for(int i=0; i<words.length; i++){
            for(int j=0; j<26; j++){
                count[j]=0;
            }
            for(int j=0; j<words[i].length(); j++){
                count[words[i].charAt(j)-'a']++;
            }
            for(int j=0; j<26; j++){
                if(count[j]<aux[j]){
                    continue out;
                }
            }
            if(min>words[i].length()){
                index = i;
                min = words[i].length();
            }
        }
        return words[index];
    }
    public static void main(String[] args){
        System.out.println(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
