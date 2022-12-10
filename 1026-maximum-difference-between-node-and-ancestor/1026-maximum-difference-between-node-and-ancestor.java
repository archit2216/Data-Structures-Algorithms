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
    public int solve(TreeNode root,int max,int min){
        if(root==null){
            return max-min;
        }
        
        max=Math.max(root.val,max);
        min=Math.min(root.val,min);
        
        int lm=solve(root.left,max,min);
        int rm=solve(root.right,max,min);
        return Math.max(lm,rm);
    }
    public int maxAncestorDiff(TreeNode root) {
        return solve(root,root.val,root.val);
    }
}