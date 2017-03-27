import java.util.Arrays;

/**
 * Created by rentseen on 17-3-27.
 */
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        int len=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(len==0 || result[len-1]!=nums1[i]){
                    result[len++]=nums1[i];
                }
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }
        int[] intersect=new int[len];
        for(int k=0;k<len;k++){
            intersect[k]=result[k];
        }
        return intersect;
    }
    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
}
