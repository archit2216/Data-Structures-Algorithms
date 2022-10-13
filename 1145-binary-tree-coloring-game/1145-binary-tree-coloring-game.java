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
    public int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int ls=countNodes(root.left);
        int rs=countNodes(root.right);
        
        return ls+rs+1;
    }
    public TreeNode find(TreeNode root,int x){
        if(root==null){
            return null;
        }
        if((root.left!=null && root.left.val==x) || (root.right!=null && root.right.val==x)){
            return root;
        }
        
        TreeNode ls=find(root.left,x);
        if(ls!=null){
            return ls;
        }
        TreeNode rs=find(root.right,x);
        if(rs!=null){
            return rs;
        }
        return null;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(root.val==x){
            TreeNode temp=root.left;
            int count1=countNodes(temp)+1;
            temp=root.right;
            int count2=countNodes(temp)+1;
            int c=Math.min(count1,count2);
            if(n-c>n/2){
                return true;
            }
            return false;
        }
        TreeNode node=find(root,x);
        if(node.left!=null && node.left.val==x){
            int count=countNodes(node.left);
            if(count<=n/2){
                return true;
            }
            
            TreeNode potential=node.left.left;
            int c=countNodes(potential);
            if(c>n/2){
                return true;
            }
            
            potential=node.left.right;
            c=countNodes(potential);
            if(c>n/2){
                return true;
            }
        }else{
            int count=countNodes(node.right);
            if(count<=n/2){
                return true;
            }
            TreeNode potential=node.right.left;
            int c=countNodes(potential);
            if(c>n/2){
                return true;
            }
            
            potential=node.right.right;
            c=countNodes(potential);
            if(c>n/2){
                return true;
            }
        }
        
        
        return false;
    }
}