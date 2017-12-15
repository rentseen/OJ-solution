import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rentseen on 17-3-19.
 */
public class Solution {
    //坑: no file; O(n)
    public static class node{
        int length=0;
        boolean ifFile=false;
        node father=null;
        int depth=0;
        List<node> sons=new ArrayList<node>();
    }
    public static node treeConstructor(String input){
        node p;
        node root=new node();
        p=root;
        for(int index=0;index<input.length();index++){

            node tmp=new node();
            tmp.depth++;
            while(input.charAt(index)=='\t'){
                tmp.depth++;
                index++;
            }
            int base=index;

            while(index<input.length() && input.charAt(index)!='\n' && input.charAt(index)!='.'){
                index++;
            }
            if(index<input.length() && input.charAt(index)=='.'){
                tmp.ifFile=true;
                index++;
            }
            while(index<input.length() && input.charAt(index)!='\n'){
                index++;
            }
            tmp.length=index-base;

            if(tmp.depth==1){
                root.sons.add(tmp);
                tmp.father=root;
            }
            else if(tmp.depth==p.depth+1){
                p.sons.add(tmp);
                tmp.father=p;
            }
            else{
                int d=p.depth;
                while(d!=tmp.depth){
                    d--;
                    p=p.father;
                }
                p.father.sons.add(tmp);
                tmp.father=p.father;
            }
            p=tmp;
        }
        return root;
    }
    public static int findMaxLength(node root){
        if(root.sons.size()==0){
            if(root.ifFile){
                return root.length;
            }
            else{
                return 0;
            }
        }
        else{
            int max=0;
            for(int i=0;i<root.sons.size();i++){
                int length=findMaxLength(root.sons.get(i));
                if(length>max){
                    max=length;
                }
            }
            if(max==0){
                return 0;
            }
            else{
                return max+root.length+(root.depth==0?0:1);
            }

        }
    }
    public static int lengthLongestPath(String input) {
        node root=treeConstructor(input);
        return findMaxLength(root);
    }
    public static void main(String[] args){
        System.out.println(lengthLongestPath("dir\n file2"));
    }
}
