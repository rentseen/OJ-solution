import java.util.ArrayList;
import java.util.List;

/**
 * Created by rentseen on 17-3-29.
 */
public class Solution {
    public static void find(int[] nums,List<Integer> list,int pos,List<List<Integer>> result){
        if(pos==nums.length){
            result.add(list);
            System.out.println(list);
            return;
        }
        else{
            List<Integer> list1=new ArrayList<Integer>();
            list1.addAll(list);
            find(nums,list1,pos+1,result);
            list.add(nums[pos]);
            List<Integer> list2=new ArrayList<Integer>();
            list2.addAll(list);
            find(nums,list2,pos+1,result);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        find(nums,list,0,result);
        return  result;
    }
    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> result=subsets(nums);
        return;
    }
}
