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
    List<List<Integer>> ans;
    
    public void helper(TreeNode root,int targetSum,List<Integer> al){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            targetSum-=root.val;
            if(targetSum==0){
                List<Integer> newAl=new ArrayList<>(al);
                newAl.add(root.val);
                ans.add(newAl);
            }
            return;
        }
        
        al.add(root.val);
        helper(root.left,targetSum-root.val,al);
        helper(root.right,targetSum-root.val,al);
        al.remove(al.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> al=new ArrayList<>();
        ans=new ArrayList<>();
        helper(root,targetSum,al);
        return ans;
    }
}