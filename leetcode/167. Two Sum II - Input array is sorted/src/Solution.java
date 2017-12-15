public class Solution {
    public static int binarySearch(int i, int[] numbers, int target){
        int low = 0;
        int high = numbers.length-1;
        while(low<high){
            int mid = low + (high - low) / 2;
            if(target<numbers[mid]){
                high = mid - 1;
            }
            else if(target>numbers[mid]){
                low = mid + 1;
            }
            else if(target == numbers[mid]){
                if(i!=mid){
                    return mid;
                }
                else if(mid-1>=0 && numbers[mid-1]==target){
                    return mid-1;
                }
                else if(mid+1<numbers.length && numbers[mid+1]==target){
                    return mid+1;
                }
                else {
                    return -1;
                }

            }
        }
        if(low!=i && target == numbers[low]){
            return low;
        }
        return -1;
    }
    public static int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        for(int i=0; i<numbers.length; i++){
            int j = binarySearch(i, numbers, target-numbers[i]);
            if(j<0){
                continue;
            }
            else {
                result[0] = i+1;
                result[1] = j+1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int nums[] = {2, 3, 4};
        int target = 6;
        int result[] = twoSum(nums, target);

    }
}
