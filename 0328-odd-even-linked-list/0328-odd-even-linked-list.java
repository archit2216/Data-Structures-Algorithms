/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
         if(head==null || head.next==null){
            return head;
        }
        
        ListNode dummyE=new ListNode(-1);
        ListNode dummyO=new ListNode(-1);
        
        ListNode tmp=head;
        ListNode etmp=dummyE;
        ListNode otmp=dummyO;
        int count=0;
        while(tmp!=null){
            if(count%2==0){
                etmp.next=tmp;
                etmp=etmp.next;
            }else{
                otmp.next=tmp;
                otmp=otmp.next;
            }
            tmp=tmp.next;
            count++;
        }
        otmp.next=null;
        etmp.next=dummyO.next;
        return dummyE.next;
    }
}