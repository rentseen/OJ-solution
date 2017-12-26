import java.util.*;

class Node{
    boolean ifWord;
    Node[] can;
    public Node(){
        ifWord=false;
        can = new Node[26];
    }
}
class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }
    public void put(String s){
        put(s, root, 0);
    }
    public Node put(String s, Node node, int d){
        if(node==null)
            node = new Node();
        if(d==s.length()){
            node.ifWord=true;
        }
        else{
            int index = s.charAt(d)-'a';
            node.can[index] = put(s, node.can[index], d+1);
        }
        return node;
    }
    public Node find(String s){
        return find(s, root, 0);
    }
    public Node find(String s, Node node, int d){
        if(d==s.length()){
            return node;
        }
        else{
            int index = s.charAt(d)-'a';
            if(node.can[index]==null)
                return null;
            else return find(s, node.can[index], d+1);
        }
    }
}

public class Solution {
    public static boolean ifIn(char[][] board, int x, int y){
        if(x<0 || x>=board.length)
            return false;
        if(y<0 || y>=board[0].length)
            return false;
        return true;
    }
    public static void dfs(Trie trie, Node root, Set<String> set, char[][] board, boolean[][] flag, StringBuilder sb, int x, int y){
        Node node = trie.find(sb.toString(), root, sb.length()-1);
        if(node==null)
            return;
        if(node.ifWord)
            set.add(sb.toString());
        flag[x][y]=true;
        if(ifIn(board, x-1, y) && !flag[x-1][y]){
            dfs(trie, node, set, board, flag, sb.append(board[x-1][y]), x-1, y);
            sb.deleteCharAt(sb.length()-1);
        }
        if(ifIn(board, x+1, y) && !flag[x+1][y]){
            dfs(trie, node, set, board, flag, sb.append(board[x+1][y]), x+1, y);
            sb.deleteCharAt(sb.length()-1);
        }
        if(ifIn(board, x, y-1) && !flag[x][y-1]){
            dfs(trie, node, set, board, flag, sb.append(board[x][y-1]), x, y-1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(ifIn(board, x, y+1) && !flag[x][y+1]){
            dfs(trie, node, set, board, flag, sb.append(board[x][y+1]), x, y+1);
            sb.deleteCharAt(sb.length()-1);
        }
        flag[x][y]=false;
    }
    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for(int i=0; i<words.length; i++){
            trie.put(words[i]);
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(trie, trie.root, set, board, flag, new StringBuilder(""+board[i][j]), i, j);
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args){
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));
    }
}
