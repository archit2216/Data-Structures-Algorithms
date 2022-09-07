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
    public String tree2str(TreeNode root) {
        if(root==null){
            return "";
        }
        
        String ans=root.val+"";
        String leftStr=tree2str(root.left);
        String rightStr=tree2str(root.right);
        
        if(leftStr=="" && rightStr==""){
            return ans;
        }
        if(leftStr==""){
            return ans+"()"+"("+rightStr+")";
        }
        if(rightStr==""){
            return ans+"("+leftStr+")";
        }
        return ans+"("+leftStr+")("+rightStr+")";
    }
}