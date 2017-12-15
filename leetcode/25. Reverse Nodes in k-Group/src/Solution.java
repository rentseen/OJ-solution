class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode front = head;
        ListNode tmp = head;
        int length = 0;
        if(front==null)
            return null;
        while(tmp!=null){
            tmp = tmp.next;
            length++;
        }
        if(length<k)
            return head;
        for(int i=0; i<k-1; i++){
            tmp = front.next;
            front.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        front.next = reverseKGroup(front.next, k);
        return head;
    }
}
