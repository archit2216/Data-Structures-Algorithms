class Solution {
    List<List<Integer>> ans;
    public void solve(int[] nums,boolean[] used,List<Integer> al,int k){
        if(k==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                al.add(nums[i]);
                solve(nums,used,al,k-1);
                used[i]=false;
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        ans=new ArrayList<>();
        solve(nums,used,new ArrayList<>(),nums.length);
        return ans;
    }
}