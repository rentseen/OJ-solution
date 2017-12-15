/**
 * Created by rentseen on 17-4-25.
 */
//最壞的情況只能是O(n)，特例是一堆1中夾了一個2
//最好的情況是O(log(n))
public class Solution {
    public static int getPivot(int[] nums,int left,int right){
        if(nums[left]<nums[right]){
            return right+1;
        }
        if(right-left==1){
            if(nums[left]>nums[right]){
                return right;
            }
            else{
                return  right+1;
            }

        }
        if(left==right){
            return left+1;
        }
        int mid=(left+right)/2;
        if(nums[mid]>nums[left]){
            return getPivot(nums,mid,right);
        }
        else if(nums[mid]==nums[left]){
            if(nums[mid]==nums[right]){
                int leftPivot=getPivot(nums,left,mid);
                int rightPivot=getPivot(nums,mid+1,right);
                if(leftPivot==mid+1){
                    leftPivot=nums.length;
                }
                if(rightPivot==right+1){
                    rightPivot=nums.length;
                }

                return (leftPivot+rightPivot)%nums.length;
            }
            else{
                return getPivot(nums,mid,right);
            }
        }
        else{
            return getPivot(nums,left,mid);
        }
    }
    public static int normPos(int pos, int pivot, int length){
        return (pos-pivot+length)%length;
    }
    public static int unNormPos(int pos, int pivot, int length){
        return (pivot+pos)%length;
    }
    public  static boolean searchT(int[] nums, int target, int left, int right,int pivot){
        if(left>right){
            return false;
        }
        int mid=(left+right)/2;
        if(nums[unNormPos(mid,pivot,nums.length)]==target){
            return true;
        }
        else if(nums[unNormPos(mid,pivot,nums.length)]<target){
            return searchT(nums,target,mid+1,right,pivot);
        }
        else{
            return searchT(nums,target,left,mid-1,pivot);
        }
    }
    public static boolean search(int[] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int pivot=getPivot(nums,0,nums.length-1)%nums.length;
        System.out.println(pivot);
        return searchT(nums,target,0,nums.length,pivot);
    }
    public static void main(String []args){
        int[] nums={1,2,1,1,1,1,1,1,1,1};
        System.out.println(search(nums,2));

    }
}
