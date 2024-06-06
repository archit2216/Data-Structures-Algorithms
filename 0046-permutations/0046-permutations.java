class Solution {
    List<List<Integer>> ans;
    public void solve(int idx,int[] nums,boolean[] vis,List<Integer> al){
        if(al.size()==nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }
    
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                al.add(nums[i]);
                solve(i+1,nums,vis,al);
                al.remove(al.size()-1);
                vis[i]=false;
            }
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis=new boolean[nums.length];
        ans=new ArrayList<>();
        solve(0,nums,vis,new ArrayList<>());
        return ans;
    }
}