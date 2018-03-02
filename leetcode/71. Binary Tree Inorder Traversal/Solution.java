import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null)
            return result;
        stack.push(root);
        while(stack.size()>0){
            TreeNode node = stack.pop();
            if(node.left==null && node.right==null){
                result.add(node.val);
            }
            else{
                if(node.right!=null){
                    stack.push(node.right);
                }
                stack.push(node);
                if(node.left!=null){
                    stack.push(node.left);
                }
                node.left=null;
                node.right=null;
            }
        }
        return result;
    }
    public static void main(String[] args){
        
    }
}