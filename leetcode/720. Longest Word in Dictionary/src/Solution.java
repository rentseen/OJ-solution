class Node{
    boolean ifString =false;
    String s;
    Node[] next = new Node[26];
}
class Trie{
    Node root = new Node();
    void put(String s){
        put(root, s, 0);
    }
    Node put(Node n, String s, int i){
        if(n==null) n = new Node();
        if(i==s.length()){
            n.ifString = true;
            n.s=s;
            return n;
        }
        char c = s.charAt(i);
        n.next[c-'a'] = put(n.next[c-'a'], s, ++i);
        return n;
    }
    String getMax(){
        StringBuilder max=new StringBuilder();
        getMax(root, max);
        return max.toString();
    }
    void getMax(Node n, StringBuilder max){
        for(int i=0; i<26; i++){
            if(n.next[i]!=null && n.next[i].ifString){
                if(n.next[i].s.length()>max.length()){
                    max.delete(0,max.length());
                    max.append(n.next[i].s);
                }

                getMax(n.next[i], max);
            }
        }
    }
}

public class Solution {



    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for(int i=0; i<words.length; i++)
            trie.put(words[i]);
        return trie.getMax();

    }
    public static void main(String[] args){
        String[] words = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(longestWord(words));
    }
}
