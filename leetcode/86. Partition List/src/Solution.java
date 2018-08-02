class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode st = smallHead;
        ListNode bt = bigHead;
        ListNode p = head;
        while(p!=null) {
            if(p.val<x) {
                st.next = p;
                st=p;
            }
            else {
                bt.next = p;
                bt=p;
            }
            p=p.next;
        }
        st.next = bigHead.next;
        bt.next = null;
        return smallHead.next;
    }
}
