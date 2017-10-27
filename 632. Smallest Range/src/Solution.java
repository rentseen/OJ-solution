import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] index = new int[k];
        for(int i=0; i<k; i++){
            index[i] = -1;
        }
        int[] result = {-100001, 100001};
        int min = 100001;
        int max = -100001;
        for (int i = 0; i < k; i++) {
            List<Integer> ls = nums.get(i);
            if (index[i] + 1 < ls.size() && ls.get(index[i] + 1) > max) {
                max = ls.get(index[i] + 1);
            }
        }
        while(true) {
            for (int i = 0; i < k; i++) {
                List<Integer> ls = nums.get(i);
                while (index[i] + 1 < ls.size() && ls.get(index[i] + 1) <= max) {
                    index[i]++;
                }
                min = Math.min(min, ls.get(index[i]));
            }
            if (result[1] - result[0] > max - min) {
                result[1] = max;
                result[0] = min;
            }
            min = 100001;
            max = 100001;
            for (int i = 0; i < k; i++) {
                List<Integer> ls = nums.get(i);
                if (index[i] + 1 < ls.size() && ls.get(index[i] + 1) < max) {
                    max = ls.get(index[i] + 1);
                }
            }
            if (max == 100001) {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[][] can = {{5,42,43,48,54,64,65},{19,20,32,32,32,33},{6,24,42,49,53,58,58,59},{6,14,28,28,34},{2,39,45,46,49,50},{7,23,23,28,43,44,44,44,44,44,44,44,44,44,44,44,44,45},{70,75,77,87,97,99,99,99,100},{-44,7,20,20,25},{-3,39,62,72,72,73},{-5,13,15,20},{-18,-4,37,61,64},{0,10,17,35,38,41},{42,58,83,86,89,92,100},{-7,15,16},{-9,83,99},{-75,16,24,52,61,93,94,97,97,99,99,100},{37,42,49,56},{-69,92,93,95,95,95,96}};
        List<List<Integer>> nums = new ArrayList<>();
        for(int i = 0; i < can.length; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0; j<can[i].length; j++){
                tmp.add(can[i][j]);
            }
            nums.add(tmp);
        }
        smallestRange(nums);
    }
}
