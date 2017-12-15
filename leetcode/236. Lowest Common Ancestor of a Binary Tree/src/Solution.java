class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    TreeNode tn;
    int status;
    Node(){
        tn=null;
        status=0;
    }
    Node(TreeNode tn, int status){
        this.tn=tn;
        this.status=status;
    }
}
public class Solution {
    public static Node find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return new Node();
        if(root == p || root ==q){
            Node n1 = find(root.left, p, q);
            Node n2 = find(root.right, p, q);
            if(n1.status == 1 || n2.status == 1)
                return new Node(root, 2);
            else
                return new Node(null, 1);
        }
        else{
            Node n1 = find(root.left, p, q);
            Node n2 = find(root.right, p, q);
            if(n1.status == 2)
                return n1;
            if(n2.status == 2)
                return n2;
            if(n1.status == 1 && n2.status == 1)
                return new Node(root, 2);
            if(n1.status == 1)
                return n1;
            if(n2.status == 1)
                return n2;
        }
        return new Node();
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = find(root, p, q).tn;
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        lowestCommonAncestor(root, root.left.left.left, root.left.right);
    }
}
