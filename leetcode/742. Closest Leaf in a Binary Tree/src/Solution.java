import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static void search(TreeNode root, LinkedList<Integer>[] graph, boolean[] ifLeaf){
        if(root.left!=null){
            graph[root.val].add(root.left.val);
            graph[root.left.val].add(root.val);
            search(root.left, graph, ifLeaf);
        }
        if(root.right!=null){
            graph[root.val].add(root.right.val);
            graph[root.right.val].add(root.val);
            search(root.right, graph, ifLeaf);
        }
        if(root.left==null && root.right==null)
            ifLeaf[root.val]=true;
    }
    public static int bfs(int s, LinkedList<Integer>[] graph, boolean[] ifLeaf){
        LinkedList<Integer> queue = new LinkedList();
        boolean[] flag = new boolean[1001];
        queue.addLast(s);
        while(queue.size()>0){
            int n = queue.pollFirst();
            if(ifLeaf[n])
                return n;
            else{
                for(int i=0; i<graph[n].size(); i++){
                    if(!flag[graph[n].get(i)]){
                        queue.addLast(graph[n].get(i));
                        flag[graph[n].get(i)]=true;
                    }
                }
            }
        }
        return s;
    }
    public static int findClosestLeaf(TreeNode root, int k) {
        LinkedList<Integer>[] graph = new LinkedList[1001];
        boolean[] ifLeaf = new boolean[1001];
        for(int i=0; i<1001; i++){
            graph[i]=new LinkedList<>();
        }
        search(root, graph, ifLeaf);
        return bfs(k, graph, ifLeaf);
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        findClosestLeaf(n1, 1);
    }
}