class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int find(TreeNode root){
        if(root==null)
            return 0;
        if((root.left!=null && root.left.val==root.val)||(root.right!=null && root.right.val==root.val)){
            int rootPath = 1 + rootFind(root.left, root.val) + rootFind(root.right, root.val);
            int sidePath = Math.max(find(root.left), find(root.right));
            return Math.max(rootPath, sidePath);
        }
        else{
            return Math.max(1, Math.max(find(root.left), find(root.right)));
        }
    }
    public int rootFind(TreeNode root, int val){
        if(root==null)
            return 0;
    	if(root.val==val)
            return 1+Math.max(rootFind(root.left, val), rootFind(root.right,val));
        else
            return 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        return find(root);
    }
}