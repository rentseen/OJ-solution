public class Solution {
    public static int countSegments(String s) {
        if(s.length()==0)
            return 0;
        int count=0;
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=' '){
                if(flag){
                    count++;
                    flag = false;
                }
            }
            else
                flag = true;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countSegments("d d "));
    }
}
