import java.util.LinkedList;

class Node {
    int h;
    int d;
    public Node(int h, int d) {
        this.h = h;
        this.d = d;
    }
    @Override
    public String toString() {
        return h+" "+d;
    }
}

public class Solution {
    public static int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(new Node(heights[0], 0));
        int max = 0;
        for(int i=1; i<heights.length; i++) {
            Node top = stack.peekLast();
            Node now = new Node(heights[i], 0);
            int depth = 0;
            if(top.h>heights[i]) {
                while(stack.size()>0) {
                    depth++;
                    top = stack.peekLast();
                    if(top.h>heights[i]) {
                        depth += top.d;
                        if((top.h*depth)>max) {
                            max = top.h*depth;
                        }
                        stack.pollLast();
                        now.d = depth;
                    }
                    else {
                        break;
                    }
                }
            }
            stack.addLast(now);
        }
        int depth = 0;
        while(stack.size()>0) {
            depth++;
            Node top = stack.peekLast();
            depth += top.d;
            if((top.h*depth)>max) {
                max = (top.h*depth);
            }
            stack.pollLast();
        }
        return max;
    }
    public static void main(String[] args) {
        largestRectangleArea(new int[]{4,2,0,3,2,4,3,4});
    }
}
