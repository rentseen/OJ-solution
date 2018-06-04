class ListNode {
    int val;     ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode end = head;
        ListNode start = head;
        for(int i=0; i<k; i++) {
            if(end.next==null) {
                k = k%(i+1);
                return rotateRight(head, k);
            }
            end = end.next;
        }
        while(end.next!=null) {
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
    public static void main(String[] args) {

    }
}
