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
    ArrayList<ArrayList<Integer>> ans;
    int count;
    public void getPaths(TreeNode root,HashMap<Integer,Integer> hm){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            HashMap<Integer,Integer> newHm=new HashMap<>(hm);
            if(newHm.containsKey(root.val)){
                int val=newHm.get(root.val);
                newHm.put(root.val,val+1);
            }else{
                newHm.put(root.val,1);
            }
            int oddvals=0;
            for(int k:newHm.keySet()){
                if(newHm.get(k)%2!=0){
                    oddvals++;
                }
            }
            if(oddvals==0 || oddvals==1){
                count++;
            }
            return;
        }
        
        if(hm.containsKey(root.val)){
            int val=hm.get(root.val);
            hm.put(root.val,val+1);
        }else{
            hm.put(root.val,1);
        }
        getPaths(root.left,hm);
        getPaths(root.right,hm);
        int val=hm.get(root.val);
        hm.put(root.val,val-1);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        ans=new ArrayList<>();
        count=0;
        getPaths(root,new HashMap<>());
        
        return count;
    }
}