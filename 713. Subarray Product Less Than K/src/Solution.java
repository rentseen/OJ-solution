public class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int back=nums.length;
        int front=nums.length;
        int product=nums[0];
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<k){
                back=i;
                front=i+1;
                product=nums[i];
                break;
            }
        }
        while(front<nums.length){
            if(product*nums[front]<k){
                product *= nums[front];
                front++;
            }
            else {
                break;
            }
        }
        if((front-back+1)%2==0){
            count += (front-back+1)/2*(front-back);
        }
        else{
            count += (front-back)/2*(front-back+1);
        }


        while(front<nums.length){
            product=product*nums[front++];
            if(product<k){
                count += front-back;
            }
            else{
                while(back<=front && product>=k){
                    product=product/nums[back++];
                    if(product<k){
                        break;
                    }
                }
                count += front-back;
            }
        }
        return count;

    }
    public static void main(String []args){
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
