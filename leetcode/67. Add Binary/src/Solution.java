public class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(a.length(), b.length());
        int carry = 0;
        for(int i=0; i<min; i++){
            int sum = a.charAt(a.length()-1-i)-'0'+b.charAt(b.length()-1-i)-'0'+carry;
            sb.insert(0, (char)('0'+sum%2));
            carry = sum/2;
        }
        if(a.length()>min){
            for(int i=min; i<a.length(); i++){
                int sum = a.charAt(a.length()-1-i)-'0'+carry;
                sb.insert(0, (char)('0'+sum%2));
                carry = sum/2;
            }
        }
        else if(b.length()>min){
            for(int i=min; i<b.length(); i++){
                int sum = b.charAt(b.length()-1-i)-'0'+carry;
                sb.insert(0, (char)('0'+sum%2));
                carry = sum/2;
            }
        }
        if(carry!=0)
            sb.insert(0,'1');
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(addBinary("1","11"));
    }
}
