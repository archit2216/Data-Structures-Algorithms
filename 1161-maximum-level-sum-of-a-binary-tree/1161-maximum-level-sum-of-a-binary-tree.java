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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        
        q.add(root);
        int maxSum=Integer.MIN_VALUE;
        int level=0;
        int maxSumLevel=level;
        while(q.size()>0){
            int size=q.size();
            int sum=0;
            level++;
            for(int i=0;i<size;i++){
                TreeNode rem=q.remove();
                sum+=rem.val;
                if(rem.left!=null){
                    q.add(rem.left);
                }
                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            if(sum>maxSum){
                maxSum=sum;
                maxSumLevel=level;
            }
        }
        return maxSumLevel;
    }
}