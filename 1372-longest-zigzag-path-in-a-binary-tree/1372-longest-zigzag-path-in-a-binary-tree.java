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
    public static class Pair{
        int leftZig;
        int rightZig;
        int maxLen;
        Pair(){}
        Pair(int leftZig,int rightZig,int maxLen){
            this.leftZig=leftZig;
            this.rightZig=rightZig;
            this.maxLen=maxLen;
        }
    }
    public Pair helper(TreeNode root){
        if(root==null){
           return new Pair(-1,-1,0);
        }
        
        Pair ls=helper(root.left);
        Pair rs=helper(root.right);
        Pair ans=new Pair();
        ans.maxLen=Math.max(Math.max(ls.maxLen,rs.maxLen),Math.max(ls.rightZig+1,rs.leftZig+1));
        ans.leftZig=ls.rightZig+1;
        ans.rightZig=rs.leftZig+1;
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        Pair ans=helper(root);
        return ans.maxLen;
    }
}