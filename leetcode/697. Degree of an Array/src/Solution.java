import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Node{
        int left;
        int right;
        int val;
        int frequency;
    }
    public static int findShortestSubArray(int[] nums) {
        List<Node> record = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<record.size();j++){
                Node tmp = record.get(j);
                if(nums[i]==tmp.val){
                    tmp.right=i;
                    tmp.frequency++;
                    break;
                }
            }
            Node n = new Node();
            n.left=i;
            n.right=i;
            n.frequency=1;
            n.val=nums[i];
            record.add(n);
        }
        int minLength=1;
        int maxFrequency=0;
        for(int i=0;i<record.size();i++){
            Node tmp = record.get(i);
            if(tmp.frequency>maxFrequency){
                maxFrequency=tmp.frequency;
                minLength=tmp.right-tmp.left+1;
            }
            else if(tmp.frequency==maxFrequency && tmp.right-tmp.left<minLength){
                minLength=tmp.right-tmp.left+1;
            }
        }
        return minLength;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }
}
