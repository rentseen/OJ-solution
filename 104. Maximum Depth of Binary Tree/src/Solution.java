import java.util.Vector;

/**
 * Created by Yelinsheng on 2017/3/16.
 */




public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=0;
        int rightDepth=0;
        if(root.left!=null){
            leftDepth=maxDepth(root.left);
        }
        if(root.right!=null){
            rightDepth=maxDepth((root.right));
        }
        return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        root.left=node1;
        TreeNode node2=new TreeNode(2);
        root.right=node2;
        TreeNode node3=new TreeNode(3);
        node1.left=node3;
        TreeNode node4=new TreeNode(4);
        node3.right=node4;
        TreeNode node5=new TreeNode(5);
        node4.left=node5;
        System.out.print(maxDepth(root));
    }




}
