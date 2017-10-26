public class Solution {
    public static void swap(int[] height, int[] pos, int i, int j){
        int tmp_height = height[i];
        int tmp_pos = pos[i];
        height[i] = height[j];
        pos[i] = pos[j];
        height[j] = tmp_height;
        pos[j] = tmp_pos;
    }
    public static int  compute(int[] height, boolean[] flag, int i, int j){
        int ceil = Math.min(height[i], height[j]);
        int low = Math.min(i, j);
        int high = Math.max(i, j);
        int result = 0;
        for(int k=low; k<=high; k++){
            flag[k] = true;
            if(height[k]<ceil){
                result += ceil-height[k];
            }
        }
        return result;
    }
    public static void sort(int[] height, int[] pos, int i, int j){
        if(i>=j){
            return;
        }
        int mid = height[i];
        int mid_pos = pos[i];
        int low = i;
        int high = j;
        while (low < high) {
            while(low<high){
                if(height[high]<mid){
                    height[low] = height[high];
                    pos[low] = pos[high];
                    low++;
                    break;
                }
                high--;
            }
            while(low<high){
                if(height[low]>=mid){
                    height[high] = height[low];
                    pos[high] = pos[low];
                    high--;
                    break;
                }
                low++;
            }
        }
        height[low] = mid;
        pos[low] = mid_pos;
        sort(height, pos, i, low-1);
        sort(height, pos, low+1, j);
    }
    public static int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int[] pos = new int[height.length];
        int[] sort_height = new int[height.length];

        for(int i=0; i<pos.length; i++){
            pos[i] = i;
            sort_height[i] = height[i];
        }
        sort(sort_height, pos, 0, height.length-1);
        int capacity=0;

        boolean[] flag = new boolean[height.length];
        flag[pos[pos.length-1]] = true;

        for(int i=height.length-2; i>=0; i--){
            if(flag[pos[i]]){
                continue;
            }
            int base = -1;
            for(int j = pos[i]-1; j>=0; j--){
                if(flag[j]){
                    base = j;
                    break;
                }
            }
            if(base==-1){
                for(int j = pos[i]+1; j<height.length; j++){
                    if(flag[j]){
                        base = j;
                        break;
                    }
                }
            }
            capacity += compute(height, flag, base, pos[i]);
        }

        return capacity;
    }
    public static void main(String[] args){
        int[] height = {1,2};
        System.out.println(trap(height));
    }
}
