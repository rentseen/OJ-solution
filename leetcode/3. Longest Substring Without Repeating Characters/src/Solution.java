/**
 * Created by Yelinsheng on 17-3-22.
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] len=new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            int base=i-1;
            while(base>0){
                if(s.charAt(i-1)==s.charAt(base-1)){
                    break;
                }
                base--;
            }
            if(i-base>len[i-1]){
                len[i]=len[i-1]+1;
            }
            else{
                len[i]=i-base;
            }
        }
        int max=0;
        for(int e:len){
            if(e>max){
                max=e;
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }
}
