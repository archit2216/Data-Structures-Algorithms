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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode oh=null;
        ListNode ot=null;
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        
        ListNode t=head;
        while(t!=null){
            if(!hs.contains(t.val)){
                ListNode forw=t.next;
                t.next=null;
                if(oh==null){
                    oh=t;
                    ot=t;
                }else{
                    ot.next=t;
                    ot=ot.next;
                }
                t=forw;
            }else{
                t=t.next;
            }
        }
        if(ot!=null){
            ot.next=null;
        }
        return oh;
    }
}