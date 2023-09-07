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
    ListNode th;
     ListNode tt;
    public void addFirst(ListNode node){
        if(th==null){
            th=node;
            tt=node;
        }else{
            node.next=th;
            th=node;
        }
    }
    
    public ListNode reverseBetween(ListNode head, int n, int m) {
           if(head==null || head.next==null || m-n<=0){
            return head;
        }
        ListNode temp=head;
        
        
        int count=1;
        while(count<n-1){
            temp=temp.next;
            count++;
        }
        ListNode curr=temp.next;
        if(n==1){
            curr=head;
        }
        count=n;
        while(count<=m ){
            ListNode forw=curr.next;
            curr.next=null;
            addFirst(curr);
            curr=forw;
            count++;
        }
        
        temp.next=th;
        tt.next=curr;
       if(n==1){
           head=th;
       }
        return head;
    }
}