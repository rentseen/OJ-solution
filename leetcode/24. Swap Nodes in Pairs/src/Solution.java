class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public void swap(ListNode pre, ListNode n1, ListNode n2) {
        pre.next=n2;
        n1.next = n2.next;
        n2.next = n1;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode n1;
        ListNode n2;
        ListNode pre;
        n1 = head;
        n2 = head.next;
        head = n2;
        n1.next = n2.next;
        n2.next = n1;
        while(n1.next!=null && n1.next.next!=null) {
            pre = n1;
            n1 = n1.next;
            n2 = n1.next;
            swap(pre, n1, n2);
        }
        return head;
    }
}
