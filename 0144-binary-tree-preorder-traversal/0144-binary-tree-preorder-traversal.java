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
    List<Integer> al;
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        
        al.add(root.val);
        solve(root.left);
        solve(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        al=new ArrayList<>();
        solve(root);
        return al;
    }
}