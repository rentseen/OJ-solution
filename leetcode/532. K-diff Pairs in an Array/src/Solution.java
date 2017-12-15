import java.util.Arrays;

public class Solution {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int back = 0;
        int front = 1;
        int count = 0;
        for(; back < nums.length; back++){
            if(back>0  && nums[back]==nums[back-1])
                continue;
            front = back + 1;
            while(front<nums.length){
                if(front - back > 1 && nums[front]==nums[front-1]){
                    front++;
                    continue;
                }
                int diff = nums[front++]-nums[back];
                if(diff == k)
                    count++;
                else if(diff > k)
                    break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {1,3,1,5,40};
        int k = 0;
        System.out.println(findPairs(nums, k));
    }
}
