import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class QNode {
    int height;
    TreeNode tn;
    QNode(int h, TreeNode n){
        height=h;
        tn=n;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<QNode> queue = new LinkedList<>();
        queue.addLast(new QNode(0, root));
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        List<Integer> row = new ArrayList<>();
        int height = 0;
        while(queue.size()!=0){
            QNode qn = queue.pollFirst();
            if(qn.tn.left!=null)
                queue.addLast(new QNode(qn.height+1, qn.tn.left));
            if(qn.tn.right!=null)
                queue.addLast(new QNode(qn.height+1, qn.tn.right));
            if(height==qn.height)
                row.add(qn.tn.val);
            else{
                result.add(row);
                row = new ArrayList<>();
                row.add(qn.tn.val);
                height++;
            }
        }
        if(row.size()!=0)
            result.add(row);
        return result;
    }
}
