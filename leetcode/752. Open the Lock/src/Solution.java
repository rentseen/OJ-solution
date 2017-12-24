import java.util.LinkedList;

class Node{
    int x1, x2, x3, x4;
    Node(int x1, int x2, int x3, int x4){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }
    Node(String s){
        x1 = s.charAt(0)-'0';
        x2 = s.charAt(1)-'0';
        x3 = s.charAt(2)-'0';
        x4 = s.charAt(3)-'0';
    }
    boolean equals(Node node){
        if(x1!=node.x1)
            return false;
        if(x2!=node.x2)
            return false;
        if(x3!=node.x3)
            return false;
        if(x4!=node.x4)
            return false;
        return true;
    }
    int getInt(){
        return x1*1000+x2*100+x3*10+x4;
    }
}
public class Solution {
    public static int getStringInt(String s){
        int x1 = s.charAt(0)-'0';
        int x2 = s.charAt(1)-'0';
        int x3 = s.charAt(2)-'0';
        int x4 = s.charAt(3)-'0';
        return x1*1000+x2*100+x3*10+x4;
    }
    public static int openLock(String[] deadends, String target) {
        int[] length = new int[10000];
        for(int i=1; i<10000; i++){
            length[i]=-2;
        }

        for(int i=0; i<deadends.length; i++){
            if(deadends[i].equals("0000"))
                return -1;
            length[getStringInt(deadends[i])]=-1;
        }
        length[0]=0;

        Node targetNode = new Node(target);
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,0));
        while(queue.size()>0){
            Node node = queue.pollFirst();
            int path = length[node.getInt()];
            if(node.equals(targetNode)){
                return path;
            }
            Node[] nodeList = {new Node((node.x1+1)%10, node.x2, node.x3, node.x4),new Node((10+node.x1-1)%10, node.x2, node.x3, node.x4),
                    new Node(node.x1, (node.x2+1)%10, node.x3, node.x4),new Node(node.x1, (node.x2-1+10)%10, node.x3, node.x4),
                    new Node(node.x1, node.x2, (node.x3+1)%10, node.x4),new Node(node.x1, node.x2, (node.x3-1+10)%10, node.x4),
                    new Node(node.x1, node.x2, node.x3, (node.x4+1)%10),new Node(node.x1, node.x2, node.x3, (node.x4-1+10)%10)};
            for(int i=0; i<nodeList.length; i++){
                int x = nodeList[i].getInt();
                if(length[x]==-2){
                    length[x]=path+1;
                    queue.addLast(nodeList[i]);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String[] deadends = {"1002","1220","0122","0112","0121"};
        String target = "1200";
        System.out.println(openLock(deadends, target));
    }
}