class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dumpHead = new ListNode(0);
        ListNode tail = dumpHead;
        ListNode p = head;
        while(p!=null) {
            if(p.next==null) {
                tail.next = p;
                tail=p;
            }
            else {
                if(p.val!=p.next.val) {
                    tail.next = p;
                    tail=p;
                }
                else {
                    while(p.next!=null && p.next.val==p.val) {
                        p = p.next;
                    }
                }
            }
            p=p.next;
        }
        tail.next=null;
        return dumpHead.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p=p.next;
        p.next = new ListNode(3);
        p=p.next;
        p.next = new ListNode(3);
        p=p.next;
        p.next = new ListNode(4);
        p=p.next;
        p.next = new ListNode(4);
        p=p.next;
        p.next = new ListNode(5);
        p=p.next;
        deleteDuplicates(head);
    }
}
