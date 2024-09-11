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
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode temp=head;
        while(temp.next!=null){
            int v1=temp.val;
            int v2=temp.next.val;
            int newVal=gcd(v1,v2);
            ListNode newNode=new ListNode(newVal);
            ListNode forw=temp.next;
            temp.next=newNode;
            newNode.next=forw;
            temp=forw;
        }
        
        return head;
        
    }
}