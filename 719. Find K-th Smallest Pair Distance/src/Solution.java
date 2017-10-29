import java.util.Arrays;

public class Solution {
    public static int smallestDistancePair(int[] nums, int k) {
        int[] count = new int[1000000];
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                count[Math.abs(nums[i] - nums[j])]++;
            }
        }
        int sum = 0;
        for(int i=0; i<1000000; i++){
            sum += count[i];
            if(sum>=k)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1,3,1};
        int k=1;
        smallestDistancePair(nums, k);
    }
}
