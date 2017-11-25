class Node {
    Node left;
    Node right;
    int start;
    int end;
    public Node(int l, int h){
        start = l;
        end = h;
        left = null;
        right = null;
    }
}
public class MyCalendar {
    Node root;
    public MyCalendar() {
        root = null;
    }

    public boolean ifIntersect(Node root, int start, int end){
        if(root.start>=end)
            return false;
        if(start>=root.end)
            return false;
        return true;
    }

    public boolean book(Node root, int start, int end){
        if(ifIntersect(root, start, end))
            return false;
        if(start<root.start){
            if(root.left==null){
                root.left = new Node(start, end);
                return true;
            }
            else
                return book(root.left, start, end);
        }
        if(start>root.start){
            if(root.right==null){
                root.right = new Node(start, end);
                return true;
            }
            else
                return book(root.right, start, end);
        }
        return false;
    }

    public boolean book(int start, int end) {
        if(root==null){
            root = new Node(start, end);
            return true;
        }
        else{
            return book(root, start, end);
        }
    }

    public static void main(String[] args){

    }
}
