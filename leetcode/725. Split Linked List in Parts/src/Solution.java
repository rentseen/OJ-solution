class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode p = root;
        while(p!=null){
            len++;
            p = p.next;
        }
        int sublen = len/k;
        int subcount = len%k;
        p = root;
        ListNode[] result = new ListNode[k];
        ListNode pre = new ListNode(-1);
        for(int i=0; i<k; i++){
            result[i]=p;
            if(sublen==0)
                pre = p;
            for(int j=0; j<sublen; j++){
                if(j==sublen-1)
                    pre = p;
                p=p.next;
            }
            if(subcount>0){
                pre=p;
                p=p.next;
                subcount--;
            }
            if(sublen!=0 || subcount>0){
                pre.next=null;
            }
        }
        return result;
    }
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        splitListToParts(n1, 5);
    }
}
