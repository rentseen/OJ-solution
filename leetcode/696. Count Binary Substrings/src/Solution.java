public class Solution {
    public static int countBinarySubstrings(String s) {
        if(s.length()<2){
            return 0;
        }
        int base=0;
        int front=0;
        int mid=0;
        int count=0;
        char type=s.charAt(0);
        while(true){
            front++;
            if(s.length()>front){
                if(mid==base && s.charAt(front)==type){

                }
                else if(mid==base && s.charAt(front)!=type){
                    mid=front;
                }
                else if(mid!=base && s.charAt(front)!=type && mid-base>front-mid){
                }
                else {
                    if(mid!=base){
                        count+=front-mid>mid-base?mid-base:front-mid;
                    }
                    base=mid;
                    front=base;
                    type=s.charAt(base);
                }
            } else {
                if(mid!=base){
                    count+=front-mid>mid-base?mid-base:front-mid;
                }
                break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s="10";
        System.out.println(countBinarySubstrings(s));
    }
}
