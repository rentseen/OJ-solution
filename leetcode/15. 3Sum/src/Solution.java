import java.util.*;

class Node implements Comparable<Node>{
    ArrayList<Integer> one;
    public Node(int x1, int x2, int x3) {
        one = new ArrayList<Integer>();
        one.add(x1);
        one.add(x2);
        one.add(x3);
        Collections.sort(one);
    }

    @Override
    public int compareTo(Node node) {
        if(!one.get(0).equals(node.one.get(0))) {
            int a = one.get(0) - node.one.get(0);
            return one.get(0) - node.one.get(0);
        }
        else if(!one.get(1).equals(node.one.get(1))) {
            return one.get(1) - node.one.get(1);
        }
        else if(!(one.get(2).equals(node.one.get(2)))) {
            return one.get(2) - node.one.get(2);
        }
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        Node node = (Node)obj;
        if(one.get(0)==node.one.get(0) && one.get(1)==node.one.get(1) && one.get(2)==node.one.get(2)) {
            return true;
        }
        return false;
    }
    public String toString() {
        return ""+one.get(0)+" "+one.get(1)+" "+one.get(2);
    }
}

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        TreeSet<Node> result = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            int low=0;
            int high=nums.length-1;
            int target = -nums[i];
            while(low<high) {
                if(low==i){
                    low++;
                }
                else if(high==i) {
                    high--;
                }
                else {
                    if(nums[low]+nums[high]==target) {
                        Node one = new Node(nums[i], nums[low], nums[high]);
                        result.add(one);
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<target){
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(Node node: result) {
            list.add(node.one);
        }
        return list;
    }
    public static void main(String[] args) {
    }
}
