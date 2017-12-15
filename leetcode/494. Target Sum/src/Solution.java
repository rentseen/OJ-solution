import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by rentseen on 17-3-17.
 */

public class Solution {
    /**recursion
    public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length==1){
            if(nums[0]==S && -nums[0]==S){
                return 2;
            }
            else if(nums[0]==S || -nums[0]==S){
                return 1;
            }
            else{
                return 0;
            }
        }
        int [] subnums=new int[nums.length-1];
        System.arraycopy(nums,1,subnums,0,nums.length-1);

        return findTargetSumWays(subnums,S+nums[0])+findTargetSumWays(subnums,S-nums[0]);
    }**/
    //坑：递归；为0的时候应该加2；S比数组总和大
    public static int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int e:nums) sum+=e;
        if(sum<S || sum<-S){
            return 0;
        }
        int [][]can=new int[22][2002];
        can[0][1000-nums[0]]+=1;
        can[0][1000+nums[0]]+=1;
        for(int i=1;i<nums.length;i++) {
            for (int k = -1000; k <= 1000; k++) {
                int j = k + 1000;
                if(j-nums[i]>=0){
                    can[i][j]=can[i][j]+can[i-1][j-nums[i]];
                }
                if(j+nums[i]<=2000){
                    can[i][j]=can[i][j]+can[i-1][j+nums[i]];
                }
            }
        }
        return can[nums.length-1][S+1000];
    }

    public static void main(String[] args){
        int[] can={1,1,1,1,1};
        int sum=3;
        System.out.println(findTargetSumWays(can,sum));
    }
}
