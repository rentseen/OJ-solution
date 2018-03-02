import java.util.List;
import java.util.ArrayList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public List<TreeNode> generate(int n, int base) {
    	List<TreeNode> result = new ArrayList<>();
    	if(n==0)
    		return result;
    	if(n==1){
    		result.add(new TreeNode(base));
    		return result;
    	}
        for(int i=0; i<n; i++){
        	List<TreeNode> list1 = generate(i, base);
        	List<TreeNode> list2 = generate(n-i-1, base+i+1);
        	if(list1.size()==0 && list2.size()==0){
        		result.add(new TreeNode(base+i));
        	}
        	else if(list1.size()==0 && list2.size()!=0){
        		for(int z=0; z<list2.size(); z++){
        			TreeNode treeNode = new TreeNode(base+i);
        			treeNode.left = null;
        			treeNode.right = list2.get(z);
        			result.add(treeNode);
        		}
        	}
        	else if(list1.size()!=0 && list2.size()==0){
        		for(int y=0; y<list1.size(); y++){
	        		TreeNode treeNode = new TreeNode(base+i);
	        		treeNode.left = list1.get(y);
	        		treeNode.right = null;
	        		result.add(treeNode);
	        	}
        	}
        	else{
        		for(int y=0; y<list1.size(); y++){
	        		for(int z=0; z<list2.size(); z++){
	        			TreeNode treeNode = new TreeNode(i+base);
	        			treeNode.left = list1.get(y);
	        			treeNode.right = list2.get(z);
	        			result.add(treeNode);
	        		}
	        	}
        	}
        }
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        return generate(n,1);
    }
}