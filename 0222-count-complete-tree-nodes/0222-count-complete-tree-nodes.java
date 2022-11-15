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
    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int ls=count(root.left);
        int rs=count(root.right);
        return ls+rs+1;
    }
    public int countNodes(TreeNode root) {
        return count(root);
    }
}