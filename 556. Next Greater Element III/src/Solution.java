public class Solution {
    public static int[] getNums(int x){
        int[] nums = new int[11];
        int length = 0;
        while(x!=0){
            nums[length++] = x%10;
            x = x / 10;
        }
        int[] result = new int[length];
        for(int i=0; i<length; i++){
            result[i] = nums[length-i-1];
        }
        return result;
    }
    public static int getResult(int[] nums){
        int result = 0;
        int base = 1;
        for(int i = nums.length-1; i>=0; i--){
            result += nums[i]*base;
            base *= 10;
        }
        int[] tmp = getNums(result);
        if(tmp.length!=nums.length || result<0)
            return -1;
        return result;
    }
    public static void sort(int[] nums, int base){
        for(int i = base+1; i<nums.length; i++){
            for(int j=i; j>base; j--){
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
                else{
                    break;
                }
            }
        }
    }
    public static int nextGreaterElement(int n) {
        int[] nums = getNums(n);
        for(int i=nums.length-2; i>=0; i--){
            int max = Integer.MAX_VALUE;
            int pos = -1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<max && nums[j]>nums[i]){
                    pos = j;
                    max = nums[pos];
                }
            }
            if(pos>=0){
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
                sort(nums, i+1);
                return getResult(nums);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(nextGreaterElement(1999999999));
    }
}
