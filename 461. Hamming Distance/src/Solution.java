public class Solution {
    public static int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while(z != 0){
            count += z%2;
            z /= 2;
        }
        return count;
    }
    public static void main(String[] args){
        hammingDistance(1, 4);
    }
}
