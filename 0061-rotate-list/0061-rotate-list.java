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
    public int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int len=length(head);
        k=k%len;
        if(k==0){
            return head;
        }
        k=len-k;
        
        ListNode temp=head;
        for(int i=0;i<k-1;i++){
            temp=temp.next;
        }       
        ListNode newHead=temp.next;
        temp.next=null;
        head=reverse(head);
        newHead=reverse(newHead);
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newHead;
        head=reverse(head);
        return head;
        
    }
}