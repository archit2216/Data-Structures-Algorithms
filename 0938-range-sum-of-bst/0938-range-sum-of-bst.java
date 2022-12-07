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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        if(root.val>=low && root.val<=high){
            int rs=rangeSumBST(root.left,low,high);
            int ls=rangeSumBST(root.right,low,high);
            sum+=root.val+ls+rs;
            return root.val+rs+ls;
        }
        
        if(root.val>high){
            return rangeSumBST(root.left,low,high);
        }
        if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }
        return sum;
    }
}