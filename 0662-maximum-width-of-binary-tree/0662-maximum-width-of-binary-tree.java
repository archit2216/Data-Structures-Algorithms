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
    public class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(root,0));
        int max=0;
        while(q.size()>0){
            int size=q.size();
            int lm=q.peek().idx;
            int rm=q.peek().idx;
            while(size>0){
                Pair rem=q.remove();
                rm=rem.idx;
                if(rem.node.left!=null){
                    q.add(new Pair(rem.node.left,2*rem.idx+1));
                }
                if(rem.node.right!=null){
                    q.add(new Pair(rem.node.right,2*rem.idx+2));
                }
                size--;
            }
            max=Math.max(max,rm-lm+1);
        }
        return max;
    }
}