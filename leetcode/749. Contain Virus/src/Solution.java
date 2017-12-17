import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node{
    int x;
    int y;
    int count;
    boolean ifFather;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
        count=0;
        ifFather = false;
    }
    public boolean equals(Node node){
        if(x!=node.x || y!=node.y)
            return false;
        return true;
    }
    public String toString(){
        return "x:"+x+" y:"+y+" count:"+count+" ifFather:"+ifFather;
    }
}

class UnionFind{
    Node[][] can;
    int[][] grid;
    public UnionFind(int m, int n, int[][] grid){
        can = new Node[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                can[i][j]=new Node(i, j);
                if(grid[i][j]==1){
                    can[i][j].ifFather=true;
                    can[i][j].count=1;
                }
            }
        }
        this.grid = grid;
    }
    public Node find(int x, int y){
        if(can[x][y].ifFather){
            return can[x][y];
        }
        else{
            return can[x][y] = find(can[x][y].x, can[x][y].y);
        }
    }
    public void union(Node n1, Node n2){
        Node f1 = find(n1.x, n1.y);
        Node f2 = find(n2.x, n2.y);
        if(f1==f2)
            return;
        if(f1.count>f2.count){
            can[f2.x][f2.y]=f1;
            f1.count += f2.count;
            f2.ifFather = false;
            f2.count = 0;
        }
        else{
            can[f1.x][f1.y]=f2;
            f2.count += f1.count;
            f1.ifFather = false;
            f1.count = 0;
        }
    }
    public List<Node> getComponent(){
        List<Node> result = new ArrayList<>();
        for(int i=0; i<can.length; i++){
            for(int j=0; j<can[0].length; j++){
                if(grid[i][j]==1 && can[i][j].x==i && can[i][j].y==j && can[i][j].ifFather){
                    result.add(can[i][j]);
                }
            }
        }
        return result;
    }
}
public class Solution {
    public static boolean ifInner(int[][] grid, int x, int y){
        if(x<0 || x>=grid.length)
            return false;
        if(y<0 || y>=grid[0].length)
            return false;
        return true;
    }
    public static void dfs(boolean[][]flag, int[][] grid, Node node, UnionFind uf){
        LinkedList<Node> stack = new LinkedList<>();
        flag[node.x][node.y]=true;
        stack.addLast(node);
        while(stack.size()>0){
            Node n = stack.pollLast();
            uf.union(node, n);
            if(ifInner(grid, n.x+1, n.y) && grid[n.x+1][n.y]==1 && !flag[n.x+1][n.y]){
                flag[n.x+1][n.y] = true;
                stack.addLast(new Node(n.x+1, n.y));
            }
            if(ifInner(grid, n.x-1, n.y) && grid[n.x-1][n.y]==1 && !flag[n.x-1][n.y]){
                flag[n.x-1][n.y] = true;
                stack.addLast(new Node(n.x-1, n.y));
            }
            if(ifInner(grid, n.x, n.y+1) && grid[n.x][n.y+1]==1 && !flag[n.x][n.y+1]){
                flag[n.x][n.y+1] = true;
                stack.addLast(new Node(n.x, n.y+1));
            }
            if(ifInner(grid, n.x, n.y-1) && grid[n.x][n.y-1]==1 && !flag[n.x][n.y-1]){
                flag[n.x][n.y-1] = true;
                stack.addLast(new Node(n.x, n.y-1));
            }
        }
    }

    public static int getThreatenNumber(int[][] grid, UnionFind uf, Node father){
        boolean[][]flag = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]!=1)
                    continue;
                Node f = uf.find(i,j);
                if(f.equals(father)){
                    if (ifInner(grid, i + 1, j) && grid[i + 1][j] == 0 && !flag[i + 1][j]) {
                        flag[i + 1][j] = true;
                    }
                    if (ifInner(grid, i - 1, j) && grid[i - 1][j] == 0 && !flag[i - 1][j]) {
                        flag[i - 1][j] = true;
                    }
                    if (ifInner(grid, i, j + 1) && grid[i][j + 1] == 0 && !flag[i][j + 1]) {
                        flag[i][j + 1] = true;
                    }
                    if (ifInner(grid, i, j - 1) && grid[i][j - 1] == 0 && !flag[i][j - 1]) {
                        flag[i][j - 1] = true;
                    }
                }
            }
        }
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(flag[i][j])
                    count++;
            }
        }
        return count;
    }

    public static int getWallNumber(int[][] grid, UnionFind uf, Node father){
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]!=1)
                    continue;
                Node f = uf.find(i,j);
                if(f.equals(father)){
                    grid[i][j]=2;
                    if (ifInner(grid, i + 1, j) && grid[i + 1][j] == 0) {
                        count++;
                    }
                    if (ifInner(grid, i - 1, j) && grid[i - 1][j] == 0) {
                        count++;
                    }
                    if (ifInner(grid, i, j + 1) && grid[i][j + 1] == 0) {
                        count++;
                    }
                    if (ifInner(grid, i, j - 1) && grid[i][j - 1] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void affect(int[][] grid){
        boolean[][]flag = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                    flag[i][j]=true;
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(!flag[i][j])
                    continue;
                if (ifInner(grid, i + 1, j) && grid[i + 1][j] == 0) {
                    grid[i + 1][j] = 1;
                }
                if (ifInner(grid, i - 1, j) && grid[i - 1][j] == 0) {
                    grid[i - 1][j] = 1;
                }
                if (ifInner(grid, i, j + 1) && grid[i][j + 1] == 0) {
                    grid[i][j + 1] = 1;
                }
                if (ifInner(grid, i, j - 1) && grid[i][j - 1] == 0) {
                    grid[i][j - 1] = 1;
                }
            }
        }
    }

    public static int containVirus(int[][] grid) {
        int result=0;
        while(true){
            boolean[][]flag = new boolean[grid.length][grid[0].length];
            UnionFind uf = new UnionFind(grid.length, grid[0].length, grid);
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(!flag[i][j] && grid[i][j]==1){
                        dfs(flag, grid, new Node(i,j), uf);
                    }
                }
            }
            List<Node> component = uf.getComponent();
            if(component.size()==0)
                break;
            int index=0;
            int max = 0;
            for(int i=0; i<component.size(); i++){
                int count = getThreatenNumber(grid, uf, component.get(i));
                if(count>max){
                    max=count;
                    index = i;
                }
            }
            result +=getWallNumber(grid, uf, component.get(index));
            affect(grid);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(containVirus(new int[][] {{0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}}));
    }
}
