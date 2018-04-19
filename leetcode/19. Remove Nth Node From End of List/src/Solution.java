class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode back = head;
        for(int i=0; front!=null && i<n; i++)
            front = front.next;
        if(front==null)
            return head.next;
        while(front.next!=null) {
            front=front.next;
            back=back.next;
        }
        back.next = back.next.next;
        return head;
    }
}
