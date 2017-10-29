public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        for(; i<bits.length-1; i++){
            if(bits[i]==1)
                i++;
        }
        if(i==bits.length-1)
            return true;
        else
            return false;
    }
    public static void main(String[] args){

    }
}
