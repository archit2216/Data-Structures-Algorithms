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
    ArrayList<Integer> al1;
    ArrayList<Integer> al2;
    public void traverse(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            al.add(root.val);
            return;
        }
        
        traverse(root.left,al);
        traverse(root.right,al);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> al1=new ArrayList<>();
        traverse(root1,al1);
        ArrayList<Integer> al2=new ArrayList<>();
        traverse(root2,al2);
        if(al1.size()==al2.size()){
            for(int i=0;i<al1.size();i++){
                if(al1.get(i)!=al2.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}