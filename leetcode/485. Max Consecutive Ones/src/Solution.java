/**
 * Created by rentseen on 17-4-20.
 */
public class Solution {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                if(max<count){
                    max=count;
                }
                count=0;
            }
        }
        if(max<count){
            max=count;
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
