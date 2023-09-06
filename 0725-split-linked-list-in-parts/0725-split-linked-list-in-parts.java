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
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=length(head);
        ListNode[] arr=new ListNode[k];
        
        int rem=len%k;
        int div=len/k;
        int i=0;
        ListNode temp=head;
        
        if(len<=k){
            while(temp!=null){
                ListNode currHead=temp;
                ListNode forw=temp.next;
                temp.next=null;
                temp=forw;
                arr[i]=currHead;
                i++;
            }
            return arr;
        }
        
        while(temp!=null && i<k){
            int p=div;
            if(rem>0){
                p=div+1;
                rem--;
            }
            ListNode currHead=temp;
            while(temp!=null && p>1){
                temp=temp.next;
                p--;
            }
            ListNode tail=temp;
            if(temp!=null){
                temp=temp.next;
                tail.next=null;
            }
            arr[i]=currHead;
            i++;
        }
        return arr;
    }
}