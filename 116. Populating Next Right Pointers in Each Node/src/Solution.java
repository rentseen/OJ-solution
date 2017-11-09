class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connectTree(TreeLinkNode leftRoot, TreeLinkNode rightRoot){
        if(leftRoot.right == null)
            return;
        TreeLinkNode left = leftRoot.right;
        TreeLinkNode right = rightRoot.left;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null)
            return;
        root.left.next = root.right;
        connect(root.left);
        connect(root.right);
        connectTree(root.left, root.right);
    }
}
