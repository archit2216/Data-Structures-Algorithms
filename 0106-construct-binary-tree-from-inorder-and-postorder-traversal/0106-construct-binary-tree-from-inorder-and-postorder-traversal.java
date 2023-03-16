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
    public TreeNode helper(int[] inorder,int[] postorder,int insi,int inei,int posi,int poei){
        if(insi>inei || posi>poei){
            return null;
        }
        
        TreeNode root=new TreeNode(postorder[poei]);
        int idx=insi;
        while(inorder[idx]!=postorder[poei]){
            idx++;
        }
        int leftElems=idx-insi;
        
        root.left=helper(inorder,postorder,insi,idx-1,posi,posi+leftElems-1);
        root.right=helper(inorder,postorder,idx+1,inei,posi+leftElems,poei-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }
}