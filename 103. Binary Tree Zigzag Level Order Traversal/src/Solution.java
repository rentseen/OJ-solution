import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public static Stack<TreeNode> traverse_one_level(Stack<TreeNode> s, boolean direction, List<List<Integer>> result){
        Stack<TreeNode> tmp_s = new Stack<>();
        List<Integer> tmp_l = new ArrayList<>();
        while(!s.empty()){
            TreeNode node = s.pop();
            if(direction){
                //left direction
                if(node.left!=null){
                    tmp_s.push(node.left);
                }
                if(node.right!=null){
                    tmp_s.push(node.right);
                }
            }
            else{
                //right direction
                if(node.right!=null){
                    tmp_s.push(node.right);
                }
                if(node.left!=null){
                    tmp_s.push(node.left);
                }
            }
            tmp_l.add(node.val);
        }
        result.add(tmp_l);
        return tmp_s;
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        //firstly, left direction
        boolean direction = true;
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        while(true){
            if(s.empty()){
                break;
            }
            s = traverse_one_level(s, direction, result);
            direction = !direction;
        }
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.right = n4;

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println("end");
    }
}