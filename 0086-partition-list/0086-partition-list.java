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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead=new ListNode(-1);
        ListNode largeHead=new ListNode(-1);
        
        ListNode smaller=smallHead;
        ListNode larger=largeHead;
        ListNode temp=head;
        
        while(temp!=null){
            if(temp.val<x){
                smaller.next=temp;
                smaller=smaller.next;
            }else{
                larger.next=temp;
                larger=larger.next;
            }
            temp=temp.next;
        }
        
        smaller.next=null;
        larger.next=null;
        if(smallHead.next==null){
            return largeHead.next;
        }else{
            smaller.next=largeHead.next;
            return smallHead.next;
        }
        
    }
}