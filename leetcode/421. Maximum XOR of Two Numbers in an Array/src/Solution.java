class Node {
    Node left;
    Node right;
}
class Trie {
    Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(int x) {
        Node node = root;
        int pos = 1<<30;
        while(pos>0) {
            if((pos&x)>0) {
                if(node.right==null)
                    node.right = new Node();
                node = node.right;
            }
            else {
                if(node.left==null)
                    node.left = new Node();
                node = node.left;
            }
            pos = pos>>1;
        }
    }
    public int getMax(int x) {
        int num = 0;
        int pos = 1<<30;
        Node node = root;
        while(pos>0) {
            if(node.left==null && node.right==null)
                return -1;
            if((pos&x)>0) {
                if(node.right!=null) {
                    node = node.right;
                    num += pos;
                }
                else {
                    node = node.left;
                }
            }
            else {
                if(node.left!=null){
                    node = node.left;
                }
                else {
                    node = node.right;
                    num += pos;
                }
            }
            pos = pos>>1;
        }
        return num;
    }

}
public class Solution {
    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i=0; i<nums.length; i++) {
            trie.insert(nums[i]);
        }
        int max=0;
        for(int i=0; i<nums.length; i++) {
            int tmp = nums[i]^trie.getMax(~nums[i]);
            if(tmp>max)
                max = tmp;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }
}
