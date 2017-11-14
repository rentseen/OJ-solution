class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean search(TreeNode root, int x){
        if(root==null)
            return false;
        if(x==root.val)
            return true;
        else if(x<root.val)
            return search(root.left, x);
        else
            return search(root.right, x);
    }
    public boolean find(TreeNode root, TreeNode subRoot, int k){
        if(subRoot==null)
            return false;
        if(k-subRoot.val!=subRoot.val && search(root, k-subRoot.val))
            return true;
        else
            return find(root, subRoot.left, k) || find(root, subRoot.right, k);
    }
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }
}