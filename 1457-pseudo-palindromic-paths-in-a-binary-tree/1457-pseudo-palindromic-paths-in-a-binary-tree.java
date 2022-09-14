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
    public void getPaths(TreeNode root,int[] map){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            int[] arr=map.clone();
            arr[root.val]++;
            int oddvals=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2!=0){
                    oddvals++;
                }
            }
            if(oddvals==0 || oddvals==1){
                count++;
            }
            return;
        }
        
        map[root.val]++;
        getPaths(root.left,map);
        getPaths(root.right,map);
        map[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        ans=new ArrayList<>();
        count=0;
        int[] map=new int[10];
        getPaths(root,map);
        
        return count;
    }
}