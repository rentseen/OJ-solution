import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildSubtree(int[] preorder, int[] inorder, int preBase, int preLength, int inBase, int inLength) {
        if(preLength==0)
            return null;
        int rootVal = preorder[preBase];
        TreeNode root = new TreeNode(rootVal);
        int leftLength = 0;
        for(; leftLength<inLength; leftLength++) {
            if(inorder[inBase+leftLength] == rootVal)
                break;
        }
        root.left = buildSubtree(preorder, inorder, preBase+1, leftLength, inBase, leftLength);
        root.right = buildSubtree(preorder, inorder, preBase+1+leftLength, preLength-leftLength-1,
                inBase+1+leftLength, inLength-leftLength-1);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubtree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    public static void main(String[] args) {

    }
}
