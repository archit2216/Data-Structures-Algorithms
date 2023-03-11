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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode construct(ListNode head){
        if(head==null){
            return null;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast.next!=null && fast.next.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null){
            prev.next=null;
        }else{
            head=null;
        }
        ListNode secHead=slow.next;
        slow.next=null;
        
        TreeNode root=new TreeNode(slow.val);
        root.left=construct(head);
        root.right=construct(secHead);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            TreeNode h=new TreeNode(head.val);
            return h;
        }
        
        return construct(head);
    }
}