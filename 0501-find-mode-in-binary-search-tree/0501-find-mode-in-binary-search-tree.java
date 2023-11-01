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
    HashMap<Integer,Integer> hm;
    int max;
    int count;
    public void solve(TreeNode root){
        if(root==null){
            return;
        }
        
        solve(root.left);
        if(hm.containsKey(root.val)){
            hm.put(root.val,hm.get(root.val)+1);
            if(max<hm.get(root.val)){
                max=hm.get(root.val);
                count=1;
            }else if(max==hm.get(root.val)){
                max=hm.get(root.val);
                count++;
            }
        }else{
            hm.put(root.val,1);
            if(max<hm.get(root.val)){
                max=hm.get(root.val);
                count=1;
            }else if(max==hm.get(root.val)){
                max=hm.get(root.val);
                count++;
            }
        }
        solve(root.right);
    }
    public int[] findMode(TreeNode root) {
        hm=new HashMap<>();
        max=0;
        count=0;
        solve(root);
        int[] arr=new int[count];
        int i=0;
        for(Integer x:hm.keySet()){
            if(hm.get(x)==max){
                arr[i]=x;
                i++;
            }
        }
        return arr;
    }
}