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
    int count;
    public class Pair{
        int sum;
        int num;
        Pair(){}
        Pair(int sum,int num){
            this.sum=sum;
            this.num=num;
        }
    }
    
    public Pair solve(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        if(root.left==null && root.right==null){
            count++;
            return new Pair(root.val,1);
        }
        
        Pair s1=solve(root.left);
        Pair s2=solve(root.right);
        
        Pair ans=new Pair();
        ans.sum=s1.sum+s2.sum+root.val;
        ans.num=s1.num+s2.num+1;
        if(ans.sum/ans.num==root.val){
            count++;
        }
        return ans;
    }
    public int averageOfSubtree(TreeNode root) {
        count=0;
        solve(root);
        return count;
    }
}