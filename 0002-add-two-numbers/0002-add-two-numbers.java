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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=l1;
        ListNode curr2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(curr1!=null && curr2!=null){
            int sum=curr1.val+curr2.val+carry;
            if(sum>9){
                sum=sum%10;
                carry=1;
            }else{
                carry=0;
            }
            
            ListNode node=new ListNode(sum);
            temp.next=node;
            temp=temp.next;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        
        while(curr1!=null){
            int sum=curr1.val+carry;
            if(sum>9){
                sum%=10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode node=new ListNode(sum);
            temp.next=node;
            temp=temp.next;
            curr1=curr1.next;
        }
        while(curr2!=null){
            int sum=curr2.val+carry;
            if(sum>9){
                sum%=10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode node=new ListNode(sum);
            temp.next=node;
            temp=temp.next;
            curr2=curr2.next;
        }
        
        if(carry>0){
            ListNode node=new ListNode(carry);
            temp.next=node;
            temp=temp.next;
        }
        temp.next=null;
        return dummy.next;
    }
}