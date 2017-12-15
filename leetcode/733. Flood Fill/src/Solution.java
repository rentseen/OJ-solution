import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Node{
    int sr;
    int sc;
    Node(int sr, int sc){
        this.sr = sr;
        this.sc = sc;
    }
}
public class Solution {
    public boolean ifAdd(boolean[][] flag, int sr, int sc, int row, int col){
        if(sr<0 || sr>=row)
            return false;
        if(sc<0 || sc>=col)
            return false;
        if(flag[sr][sc])
            return false;
        return true;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] flag = new boolean[image.length][image[0].length];
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(new Node(sr, sc));
        int startColor = image[sr][sc];
        while(stack.size()>0){
            Node tmp = stack.poll();
            if(image[tmp.sr][tmp.sc]==startColor){
                image[tmp.sr][tmp.sc]=newColor;
                flag[tmp.sr][tmp.sc]=true;
                if(ifAdd(flag, tmp.sr-1, tmp.sc, image.length, image[0].length))
                    stack.push(new Node(tmp.sr-1, tmp.sc));
                if(ifAdd(flag, tmp.sr+1, tmp.sc, image.length, image[0].length))
                    stack.push(new Node(tmp.sr+1, tmp.sc));
                if(ifAdd(flag, tmp.sr, tmp.sc-1, image.length, image[0].length))
                    stack.push(new Node(tmp.sr, tmp.sc-1));
                if(ifAdd(flag, tmp.sr, tmp.sc+1, image.length, image[0].length))
                    stack.push(new Node(tmp.sr, tmp.sc+1));
            }
        }
        return image;
    }
}
