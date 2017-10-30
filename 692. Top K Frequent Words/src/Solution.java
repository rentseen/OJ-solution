import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Node{
    String word;
    int count;
    Node next;
    Node(String w){
        word = w;
        count = 1;
        next = null;
    }
    @Override
    public int hashCode(){
        return word.hashCode();
    }
    public boolean less(Node n){
        if(count<n.count)
            return true;
        else if(count>n.count)
            return false;
        else{
            int result = word.compareTo(n.word);
            if(result>0)
                return true;
            else
                return false;
        }
    }
}
class HTable{
    int N ;
    Node[] base;
    int pos;
    Node cur;
    public HTable(){
        N = 100000;
        base = new Node[N];
        pos = -1;
        cur = null;
    }
    void put(String w){
        int index = (w.hashCode() % N+N)%N;
        Node n = base[index];
        if(n==null)
            base[index] = new Node(w);
        else{
            while (n.next!=null){
                if(n.word.equals(w)) {
                    n.count++;
                    return;
                }
                n = n.next;
            }
            if(n.word.equals(w))
                n.count++;
            else
                n.next = new Node(w);
        }
    }
    Node fetchOne(){
        if(cur==null){
            while(++pos<N && base[pos]==null);
            if(pos==N)
                return null;
            cur = base[pos].next;
            return base[pos];
        }
        else{
            Node result = cur;
            cur = cur.next;
            return result;
        }
    }
}
class MinPH{
    int N;
    Node[] base;
    int capacity;
    public MinPH(int k){
        capacity = k + 1;
        N = 0;
        base = new Node[capacity];
    }
    void insert(Node n){
        base[++N] = n;
        swim(N);
    }
    void swim(int n){
        while(n>1 && base[n].less(base[n/2])){
            exchange(n, n/2);
            n = n/2;
        }
    }
    void delMin(){
        base[1] = base[N--];
        sink(1);
    }
    void sink(int n){
        while(2*n<=N){
            int min = 2*n;
            if(2*n+1<=N && base[2*n+1].less(base[min]))
                min= 2*n+1;
            if(base[min].less(base[n])){
                exchange(min, n);
                n = min;
            }
            else
                break;
        }
    }
    Node getMin(){
        return base[1];
    }
    boolean ifEmpty(){
        return N==0;
    }
    void exchange(int i, int j){
        Node tmp = base[i];
        base[i] = base[j];
        base[j] = tmp;
    }
}

public class Solution {
    public static void qSort(Node[] nl, int low, int high){
        if(low>=high)
            return;
        Node n = nl[low];
        int l = low;
        int h = high;
        while(l<h){
            while(l<h && nl[h].less(n))
                h--;
            if(l<h)
                nl[l]=nl[h];
            while(l<h && !nl[l].less(n))
                l++;
            if(l<h)
                nl[h]=nl[l];
        }
        nl[l]=n;
        qSort(nl, low, l-1);
        qSort(nl,l+1, high);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HTable ht = new HTable();
        MinPH ph = new MinPH(k);
        for(int i=0; i< words.length; i++){
            ht.put(words[i]);
        }
        while(true){
            Node n = ht.fetchOne();
            if(n==null)
                break;
            else{
                if(ph.N<k){
                    ph.insert(n);
                }
                else{
                    if(ph.getMin().less(n)){
                        ph.delMin();
                        ph.insert(n);
                    }
                }
            }
        }
        Node[] nl = new Node[ph.N];
        for(int i=1; i<=ph.N; i++){
            nl[i-1] = ph.base[i];
        }
        qSort(nl, 0, nl.length-1);
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<nl.length; i++){
            al.add(nl[i].word);
        }
        return al;
    }
    public static void main(String[] args){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(words, 2);
    }
}
