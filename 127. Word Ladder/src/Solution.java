import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rentseen on 17-4-26.
 */
//深度优先搜索计算复杂度太高，因为有可能会重复搜索一些子树，广度优先搜索则比较合合适，复杂度为O(n^2)
public class Solution {

    public static boolean ifOneStep(String beginWord,String endWord){
        int count=0;
        for(int i=0;i<beginWord.length();i++){
            if(beginWord.charAt(i)!=endWord.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        if(count==1){
            return true;
        }
        else{
            return false;
        }
    }
    /*深度优先搜索
    public static int search(String beginWord,String endWord,List<String> wordList,List<Boolean> flag,int length){
        if(beginWord.equals(endWord)){
            return length;
        }
        int result=wordList.size()+2;
        for(int i=0;i<wordList.size();i++){
            if(!flag.get(i) && ifOneStep(beginWord,wordList.get(i))){
                List<Boolean> cflag=new ArrayList<Boolean>();
                cflag.addAll(flag);
                cflag.set(i,true);
                int tmp=search(wordList.get(i),endWord,wordList,cflag,length+1);
                if(tmp<result){
                    result=tmp;
                }
            }
        }
        return result;
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Boolean> flag=new ArrayList<Boolean>();
        for(int i=0;i<wordList.size();i++){
            flag.add(false);
        }
        int tmp=search(beginWord,endWord,wordList,flag,1);
        return tmp==(wordList.size()+2)?0:tmp;
    }
    */
    //广度优先搜索
    static class node{
        String word;
        int deep;
        node(String w,int d){
            word=w;
            deep=d;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<node> queue=new ArrayList<node>();
        queue.add(new node(beginWord,1));
        while(queue.size()>0){
            node tmp=queue.remove(0);
            if(tmp.word.equals(endWord)){
                return tmp.deep;
            }
            for(int i=wordList.size()-1;i>=0;i--){
                if(ifOneStep(wordList.get(i),tmp.word)){
                    queue.add(new node(wordList.get(i),tmp.deep+1));
                    wordList.remove(i);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList= new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
