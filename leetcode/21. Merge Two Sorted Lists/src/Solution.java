class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        if(l1==null && l2!=null)
            return l2;
        if(l1!=null && l2==null)
            return l1;
        ListNode head;
        ListNode node;
        if(l1.val<l2.val) {
            head = l1;
            l1=l1.next;
        }
        else {
            head=l2;
            l2=l2.next;
        }
        node=head;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                node.next=l1;
                node=node.next;
                l1=l1.next;
            }
            else {
                node.next=l2;
                node=node.next;
                l2=l2.next;
            }
        }
        if(l1!=null) {
           node.next=l1;
        }
        if(l2!=null) {
            node.next=l2;
        }
        return head;
    }
}
