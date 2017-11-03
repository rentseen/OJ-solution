import java.util.Arrays;

public class Solution {
    public static void insertSort(int[] count, int length){
        for(int i=1; i<length; i++){
            for(int j=i; j>0; j--){
                if(count[j]>count[j-1]){
                    int tmp = count[j];
                    count[j] = count[j-1];
                    count[j-1] = tmp;
                }
                else
                    break;
            }
        }
    }
    public static int longestPalindrome(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        int[] count = new int[52];
        int length=0;
        int c=1;
        for(int i=0; i<letters.length-1; i++){
            if(letters[i]!=letters[i+1]){
                count[length++]=c;
                c=1;
            }
            else{
                c++;
            }
        }
        count[length++]=c;
        insertSort(count, length);

        boolean flag = false;
        int result=0;
        for(int i=0; i<length; i++){
            if(!flag && count[i]%2==1){
                flag=true;
                result += count[i];
            }
            else if(flag && count[i]==1){
                break;
            }
            else{
                result += count[i]/2*2;
            }
        }

        return result;
    }
    public static void main (String[] args){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
