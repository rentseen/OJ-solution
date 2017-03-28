/**
 * Created by Yelinsheng on 2017/3/28.
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean find(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        else if((left==null&&right!=null)||(left!=null&&right==null)){
            return false;
        }
        else{
            if(left.val!=right.val){
                return false;
            }
            else{
                return find(left.left,right.right)&&find(left.right,right.left);
            }
        }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            return find(root.left,root.right);
        }
    }
    public static void main(String[] args){

    }
}
