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
    public ListNode reverse(ListNode root){
        ListNode curr=root;
        ListNode prev=null;
        
        while(curr!=null){
            ListNode forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        
        ListNode t1=l1;
        ListNode t2=l2;
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(t1!=null && t2!=null){
            int sum=t1.val+t2.val+carry;
            if(sum>9){
                carry=1;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode newNode=new ListNode(sum);
            temp.next=newNode;
            temp=temp.next;
            t1=t1.next;
            t2=t2.next;
        }
        while(t1!=null){
            int sum=t1.val+carry;
            if(sum>9){
                carry=1;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode newNode=new ListNode(sum);
            temp.next=newNode;
            temp=temp.next;
            t1=t1.next;
        }
        while(t2!=null){
            int sum=t2.val+carry;
            if(sum>9){
                carry=1;
                sum=sum%10;
            }else{
                carry=0;
            }
            ListNode newNode=new ListNode(sum);
            temp.next=newNode;
            temp=temp.next;
            t2=t2.next;
        }
        if(carry>=1){
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
            temp=temp.next;
        }
        temp.next=null;
        ListNode newHead=reverse(dummy.next);
        return newHead;
    }
}