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
        ListNode prev=null;
        ListNode curr=head;
        ListNode forw=null;
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode newHead=slow.next;
        slow.next=null;
        
        newHead=reverse(newHead);
        ListNode t1=head;
        ListNode t2=newHead;
        while(t1!=null && t2!=null){
            if(t1.val!=t2.val){
                return false;
            }
            t1=t1.next;
            t2=t2.next;
        }
        newHead=reverse(newHead);
        slow.next=newHead;
        return true;
    }
}