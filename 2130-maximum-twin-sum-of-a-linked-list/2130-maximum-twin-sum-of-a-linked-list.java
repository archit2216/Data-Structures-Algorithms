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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode secHead=slow.next;
        slow.next=null;
        secHead=reverse(secHead);
        
        int max=0;
        ListNode t1=head;
        ListNode t2=secHead;
        while(t1!=null && t2!=null){
            max=Math.max(t1.val+t2.val,max);
            t1=t1.next;
            t2=t2.next;
        }
        return max;
        
    }
}