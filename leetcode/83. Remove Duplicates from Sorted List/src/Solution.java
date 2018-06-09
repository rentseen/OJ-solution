class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpHead = new ListNode(0);
        ListNode base = dumpHead;
        ListNode p = head;
        while(p!=null) {
            if(p.next==null) {
                base.next=p;
                base=p;
            }
            else {
                base.next=p;
                base=p;
                while(p.next!=null && p.next.val==p.val) {
                    p=p.next;
                }
            }
            p=p.next;
        }
        base.next=null;
        return dumpHead.next;
    }
}
