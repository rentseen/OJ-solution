public class Solution {
    public static int lengthOfLastWord(String s) {
        int back=s.length()-1;
        for(; back>=0;back--){
            if(s.charAt(back)!=' ')
                break;
        }
        int front = back;
        for(; front>=0; front--){
            if(s.charAt(front)==' ')
                break;
        }
        return back-front;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("  aa  a"));
    }
}
