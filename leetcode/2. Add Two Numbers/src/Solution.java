import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long result = 0;
        int a = 0;
        int x = 0;
        int y = 0;
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while(l1!=null && l2!=null) {
            x = l1.val;
            y = l2.val;
            if(head.val==-1) {
                head.val = (a+x+y)%10;
                tmp=head;
            }
            else {
                tmp.next = new ListNode((a+x+y)%10);
                tmp=tmp.next;
            }
            a = (a+x+y)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null) {
            x = l1.val;
            tmp.next = new ListNode((a+x)%10);
            tmp=tmp.next;
            a = (a+x)/10;
            l1 = l1.next;
        }
        while(l2!=null) {
            x = l2.val;
            tmp.next = new ListNode((a+x)%10);
            tmp=tmp.next;
            a = (a+x)/10;
            l2 = l2.next;
        }
        if(a!=0)
            tmp.next = new ListNode((a)%10);
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode tmp = l2;
        for(int i=0;i<9; i++){
            tmp.next = new ListNode(9);
            tmp = tmp.next;
        }
        addTwoNumbers(l1, l2);
    }
}
