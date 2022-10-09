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
    boolean flag=false;
    HashSet<Integer> hs=new HashSet<>();
    public void solve(TreeNode root,int k){
        if(root==null){
            return;
        }
        
        solve(root.left,k);
        if(hs.contains(k-root.val)){
            flag=true;
            hs.remove(k-root.val);
        }
        hs.add(root.val);
        solve(root.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        solve(root,k);
        return flag;
    }
}