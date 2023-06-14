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
    TreeNode n1=null;
    TreeNode n2=null;
    int ans;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        if(n1==null && n2==null){
            n2=root;
        }else if(n1==null){
            n1=root;
            ans=Math.min(Math.abs(n1.val-n2.val),ans);
        }else{
            n2=n1;
            n1=root;
            ans=Math.min(Math.abs(n1.val-n2.val),ans);
        }
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        ans=Integer.MAX_VALUE;
        inorder(root);
        return ans;
    }
}