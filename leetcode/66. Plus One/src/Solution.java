public class Solution {
    public int[] plusOne(int[] digits) {
        int advance = 1;
        for(int i=digits.length-1; i>=0; i--) {
            advance = digits[i]+advance;
            digits[i] = advance%10;
            advance = advance/10;
        }
        if(advance!=0) {
            int [] result = new int[digits.length+1];
            result[0] = advance;
            for(int i=0; i<digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }
    public static void main(String[] args) {

    }
}
