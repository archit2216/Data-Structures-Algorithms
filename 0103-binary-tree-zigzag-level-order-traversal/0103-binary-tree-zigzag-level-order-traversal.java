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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        
        int count=0;
        st.push(root);
        while(st.size()>0){
            TreeNode rem=st.pop();
            al.add(rem.val);
            if(count%2==0){
                if(rem.left!=null){
                    st2.push(rem.left);
                }
                if(rem.right!=null){
                    st2.push(rem.right);
                }
            }else{
                if(rem.right!=null){
                    st2.push(rem.right);
                }
                if(rem.left!=null){
                    st2.push(rem.left);
                }
            }
            if(st.size()==0){
                st=st2;
                st2=new Stack<>();
                ans.add(al);
                al=new ArrayList<>();
                count++;
            }
        }
        return ans;
    }
}