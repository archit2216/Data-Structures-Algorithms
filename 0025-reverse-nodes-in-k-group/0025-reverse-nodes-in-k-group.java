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
    ListNode oh=null;
    ListNode ot=null;
    public int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        
        int len=length(head);
        ListNode th=null;
        ListNode tt=null;
        ListNode temp=head;
        while(len>=k){
            int count=0;
            while(count<k){
                ListNode curr=temp;
                temp=curr.next;
                curr.next=null;
                if(th==null){
                    th=curr;
                    tt=curr;
                }else{
                    curr.next=th;
                    th=curr;
                }
                count++;
            }
            
            if(oh==null){
                oh=th;
                ot=tt;
            }else{
                ot.next=th;
                ot=tt;
            }
            th=null;
            tt=null;
            len-=k;
        }
        if(ot!=null){
            ot.next=temp;
        }
        return oh;
    }
}