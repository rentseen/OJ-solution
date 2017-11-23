public class Solution {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int base = 0;
        int length = 1;
        boolean direction = true;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[0]){
                direction = nums[i]-nums[0]>0;
                length++;
                break;
            }
        }
        for(int i=2; i<nums.length; i++){
            for(int j=i-1; j>base; j--){
                if(nums[i]!=nums[j] && (nums[i]-nums[j]>0)==!direction){
                    base = j;
                    i = base;
                    length++;
                    direction = !direction;
                    break;
                }
            }
        }
        return length;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,7,4,4,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
