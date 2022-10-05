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
    public void addHelper(TreeNode root,int val,int depth){
        if(root==null){
            return;
        }
        if(depth==2){
            TreeNode nodels=new TreeNode(val);
            TreeNode noders=new TreeNode(val);
            TreeNode ls=root.left;
            TreeNode rs=root.right;
            root.left=nodels;
            root.right=noders;
            nodels.left=ls;
            noders.right=rs;
            return;
        }
        
        addHelper(root.left,val,depth-1);
        addHelper(root.right,val,depth-1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        addHelper(root,val,depth);
        return root;
    }
}