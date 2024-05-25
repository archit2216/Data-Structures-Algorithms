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
    public ListNode mergeLists(ListNode h1,ListNode h2){
        ListNode dummy=new ListNode(-1);
        ListNode t=dummy;
        
        ListNode t1=h1;
        ListNode t2=h2;
        
        while(t1!=null && t2!=null){
            if(t1.val<t2.val){
                t.next=t1;
                t1=t1.next;
            }else{
                t.next=t2;
                t2=t2.next;
            }
            t=t.next;
        }
        
        while(t1!=null){
            t.next=t1;
            t=t.next;
            t1=t1.next;
        }
        while(t2!=null){
            t.next=t2;
            t=t.next;
            t2=t2.next;
        }
        
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        else if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        
        return mergeLists(list1,list2);
    }
}