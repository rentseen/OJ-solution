import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Heap {
    List<ListNode> can;
    public Heap() {
        can = new ArrayList<>();
        can.add(new ListNode(-1));
    }
    public void swim(int k) {
        while(k>1) {
            if(can.get(k/2).val>can.get(k).val) {
                swap(k/2, k);
                k = k/2;
            }
            else
                break;
        }
    }
    public void sink(int k) {
        int len = can.size();
        while(2*k<len) {
            int i = 2*k;
            if(i<len-1 && can.get(i).val>can.get(i+1).val)
                i++;
            if(can.get(i).val<can.get(k).val) {
                swap(i,k);
                k = i;
            }
            else
                break;
        }
    }
    public void insert(ListNode node) {
        can.add(node);
        swim(can.size()-1);
    }
    public ListNode pick() {
        if(can.size()==1) {
            return null;
        }
        ListNode node = can.get(1);
        if(node.next==null) {
            can.set(1, can.get(can.size()-1));
            can.remove(can.size()-1);
        }
        else {
            can.set(1, node.next);
        }
        sink(1);
        node.next = null;
        return node;
    }
    public void swap(int i, int j) {
        ListNode tmp = can.get(i);
        can.set(i, can.get(j));
        can.set(j, tmp);
    }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Heap heap = new Heap();
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null)
                heap.insert(lists[i]);
        }
        ListNode head = heap.pick();
        ListNode pre = head;
        while(true) {
            ListNode node = heap.pick();
            if(node==null)
                break;
            pre.next = node;
            pre=node;
        }
        return head;
    }
    public static void main(String[] args) {

    }
}
