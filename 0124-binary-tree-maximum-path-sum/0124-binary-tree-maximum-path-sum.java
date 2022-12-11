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
    int maxSum;
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int ls=helper(root.left);
        int rs=helper(root.right);
        int sum=Math.max(root.val+ls+rs,Math.max(root.val,Math.max(ls+root.val,rs+root.val)));
        if(maxSum<sum){
            maxSum=sum;
        }
        return root.val+Math.max(0,Math.max(ls,rs));
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
}