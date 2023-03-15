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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        boolean complete=false;
        q.add(root);
        while(q.size()>0){
            TreeNode rem=q.remove();
            if(rem==null){
                complete=true;
            }else{
                if(complete){
                    return false;
                }
                q.add(rem.left);
                q.add(rem.right);
            }
        }
        return true;
    }
}