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
    boolean flag=true;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int ls=height(root.left);
        int rs=height(root.right);
        if(Math.abs(ls-rs)>1){
            flag=false;
        }
        return Math.max(ls,rs)+1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }
}