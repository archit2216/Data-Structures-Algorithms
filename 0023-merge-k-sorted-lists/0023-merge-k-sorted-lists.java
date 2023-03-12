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
    private ListNode mergeTwoSortedLists(ListNode l1,ListNode l2){
        if(l1==null && l2==null){
            return null;
        }
        
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        
        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        ListNode temp=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        
        if(l1!=null){
            temp.next=l1;
        }if(l2!=null){
            temp.next=l2;
        }
        
        return head;
    }
    
   
     private ListNode mergeKListshelper(ListNode[] lists,int si,int ei){
        if(si>ei){
            return null;
        }
        if(si==ei){
            return lists[si];
        }
        
        int mid=(si+ei)/2;
        
        ListNode l1=mergeKListshelper(lists,si,mid);
        ListNode l2=mergeKListshelper(lists,mid+1,ei);
        
        return mergeTwoSortedLists(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        
        return mergeKListshelper(lists,0,lists.length-1);
    }
}