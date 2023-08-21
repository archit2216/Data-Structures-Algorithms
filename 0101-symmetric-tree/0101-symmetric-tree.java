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
    public boolean isMirror(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        else if(node1==null && node2!=null){
            return false;
        }
        else if(node2==null && node1!=null){
            return false;
        }else if(node1.val!=node2.val){
            return false;
        }
        
        boolean LeftnRight=isMirror(node1.left,node2.right);
        boolean RightnLeft=isMirror(node1.right,node2.left);
        return (LeftnRight && RightnLeft);
    }
    public boolean isSymmetric(TreeNode root) {
        boolean check=isMirror(root,root);
        return check;
    }
}